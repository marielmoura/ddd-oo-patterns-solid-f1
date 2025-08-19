---
id: refactor-autopilot
mode: agent
applyTo: "src/main/**"
description: "Executar refactoring em batches guiado por analysis.json/backlog.json"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

````prompt
# Refactoring Autônomo — Correção Gradual com Checklist (Java/Spring)

Este prompt transforma achados fracos e críticos do seu relatório (analysis.json) em correções graduais, validadas por testes, com commits e checklist de progresso no VS Code.

---

## Contexto (preencha)
- Insumo principal: caminho do analysis.json ou conteúdo JSON colado
- Repositório alvo: {{repo_path}}
- Stack: Java {{java_version|17}}, Spring Boot {{spring_boot_version|3.3}}, Build {{build_tool|Auto}}, DB {{db|PostgreSQL}}
- Batch: até {{batch_size|3}} itens por execução
- Limites: {{max_batches|auto}}, {{security_limits|auto}}
 - ALLOW_EDIT = ["src/main/java/**","src/test/java/**","pom.xml","build.gradle","build.gradle.kts","settings.gradle*","application*.yml","application*.properties"]
 - DENY_EDIT  = ["target/**","build/**","**/generated/**","**/generated-sources/**","**/*.min.*","**/.idea/**","**/.vscode/**"]

## Escala
- Severidade: S0 bloqueante, S1 crítico, S2 alto, S3 médio, S4 baixo, S5 cosmético
- Prioridade: MoSCoW [Must, Should, Could, Won’t]

## Escopo da execução
- Gerar ou carregar backlog.json a partir de analysis.json (foco em Must/Should e S0–S2)
- Processar em lotes até 3 itens elegíveis por batch (sem dependências pendentes)
- Para cada item: planejar → aplicar patch → criar/ajustar testes → validar (build/estáticos) → commit → atualizar backlog
- Emitir progress.json consolidado, patches (diff unificado) e checklist.md
- Validar e, se necessário, corrigir JSONs gerados (backlog.json e progress.json) antes de prosseguir
- Repetir automaticamente até esgotar o backlog ou atingir limites
 - Fail-fast global: interromper se 2 batches consecutivos falharem na validação (não aplicar novos patches a partir daí)

## Regras
- Detecção de build
  - Se existir pom.xml → Maven; se existir build.gradle[.kts] → Gradle. Usar o que for encontrado.
- Comandos de validação
  - Maven:
    - mvn -q -DskipTests=false -DfailIfNoTests=false test
    - mvn -q -DskipTests=false verify
    - Se plugins presentes no pom.xml, executar também: spotless:apply, checkstyle:check, spotbugs:check, pmd:check
    - Integração (se perfil existir): mvn -q -P it verify
  - Gradle:
    - ./gradlew test
    - ./gradlew check
    - Integração (se existir): ./gradlew integrationTest
- Modo autônomo
  - Trabalhar em batches; ao final de cada batch, continuar automaticamente se houver itens e limites não atingidos
  - Primeiro batch pode operar em modo dry-run (patch only) para inspeção; aplicar em seguida se aprovado (ou em modo automático, aplicar após dry-run bem-sucedido)
  - Quota de diffs: máximo de 1000 linhas alteradas por batch
  - Retentativa por item: no máximo 2 tentativas, com backoff incremental
- Commits
  - Mensagem: tipo(escopo): resumo (#ID) — ex.: feat(validation): enforce Bean Validation on User endpoints (#SEC-001)
  - Branch obrigatório: refactor/autopilot-<ISO-8601>; abrir PR em modo draft (não comitar em main)
- Itens bloqueados
  - Sem evidência suficiente → marcar status "Blocked" no progress.json e seguir para os demais
- Validação de JSON
  - Após gerar qualquer arquivo JSON (backlog.json, progress.json), validar a sintaxe com parser estrito.
  - Se inválido, aplicar correções automáticas comuns (remover vírgulas finais, normalizar aspas, fechar chaves/colchetes) e revalidar.
  - Persistir e utilizar apenas JSON válido; se não for possível corrigir, não prosseguir com o passo dependente e registrar observação no progress.json do batch anterior.
  - Validar também contra os schemas JSON canônicos em prompts/refactoring (analysis.schema.json, backlog.schema.json, progress.schema.json) quando presentes.

## Saídas obrigatórias
1) progress.json: objeto JSON válido seguindo o esquema definido
2) Patches: bloco(s) diff unificado com todas as alterações
3) checklist.md: checklist consolidado com [x]/[ ] dos itens trabalhados

## Mapeamento analysis.json → backlog.json
- Selecionar backlog_melhoria com prioridade ∈ {Must, Should} e severidade ∈ {S0, S1, S2}
- Para cada item:
  - id: usar existente se houver; senão gerar ${TOPICO}-${contador} (ex.: SEC-001)
  - topico: copiar de topico
  - titulo: copiar de item
  - descricao: sumarizar recomendações
  - severidade, prioridade, effort: copiar
  - arquivos_alvo: de evidencias ou vazio
  - criterios_de_pronto: derivados de recomendacoes e riscos
  - estado: "Todo"
  - estado ∈ {"Todo","InProgress","Done","Blocked","NeedsReview"}
  - dependencias/evidencias: se houver

### Esquema backlog.json
```json
{
  "itens": [
    {
      "id": "SEC-001",
      "topico": "Seguranca",
      "titulo": "Enforce Bean Validation nos DTOs de entrada",
      "descricao": "Adicionar @Valid/@Validated em controllers e constraints em DTOs",
      "prioridade": "Must",
      "severidade": "S2",
      "effort": "S",
      "arquivos_alvo": [
        "src/main/java/.../UserController.java",
        "src/main/java/.../UserRequest.java"
      ],
      "criterios_de_pronto": [
        "Controllers anotados com @Validated/@Valid",
        "DTOs com @NotNull/@Size conforme regras",
    "Teste falha quando constraint é violada",
    "Nenhuma nova violação de análise estática"
      ],
      "estado": "Todo",
      "dependencias": [],
      "evidencias": []
    }
  ],
  "metadados": { "gerado_de": "analysis.json", "data": "YYYY-MM-DDTHH:mm:ssZ" }
}
```

## Esquema progress.json (saída)
```json
{
  "batch_id": "<ISO-8601>",
  "itens_processados": [
    {
      "id": "SEC-001",
      "antes_resumo": "Controller aceita payloads inválidos",
      "depois_resumo": "Validação aplicada e testada",
      "status": "Done|NeedsReview|Blocked",
      "arquivos_modificados": ["path1", "path2"],
      "novos_testes": ["pathTest1"],
      "comando_validacao": ["mvn -q test"],
      "resultado_validacao": { "sucesso": true, "tests_passed": 42, "tests_failed": 0 },
      "commit": {
        "hash": "<hash>",
        "mensagem": "feat(validation): enforce Bean Validation on User endpoints (#SEC-001)"
      },
  "observacoes": "",
  "telemetry": { "tests_total": 42, "coverage_media_tocados": 0.8, "duracao_segundos": 35.2 }
    }
  ],
  "checklist_markdown": "- [x] SEC-001 Enforce Bean Validation...\n- [ ] ARQ-003 Corrigir ciclo de dependência...",
  "proximos_passos": ["id1", "id2", "id3"]
}
```

## Formato dos patches (obrigatório)
- Usar diff unificado
```diff
--- a/src/main/java/.../UserController.java
+++ b/src/main/java/.../UserController.java
@@
- public ResponseEntity<User> create(@RequestBody UserRequest req) {
+ public ResponseEntity<User> create(@Valid @RequestBody UserRequest req) {
   // ...
 }
```

## Critérios de validação por item
- Todos os criterios_de_pronto atendidos
- Todos os testes passam
- Análises estáticas sem novos erros
- Cobertura dos arquivos tocados ≥ 80% quando viável

## Fluxo
1) Carregar ou gerar backlog.json a partir de analysis.json (validar e corrigir JSON, se necessário)
2) Selecionar até 3 itens elegíveis
3) Para cada item: planejar → aplicar patch → testes → validação → commit → atualizar backlog
4) Emitir progress.json consolidado, patches e checklist.md (validar e corrigir JSON, se necessário)
5) Parar (ou repetir se houver itens e limites não atingidos)

## Schemas JSON (canônicos em prompts/refactoring; opcional replicar na raiz)
- prompts/refactoring/analysis.schema.json (para analysis.json)
- prompts/refactoring/backlog.schema.json (para backlog.json)
- prompts/refactoring/progress.schema.json (para progress.json)
- Opcional: manter cópias espelhadas na raiz para ferramentas externas

Exemplo mínimo de analysis.schema.json (draft-07):
```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "analysis.json",
  "type": "object",
  "required": [
    "content_hash",
    "resumo_executivo",
    "matriz_pontuacao",
    "achados_detalhados",
    "ddd_focus",
    "arquitetura",
    "testes_qualidade",
    "backlog_melhoria",
    "metadados"
  ],
  "properties": {
    "content_hash": { "type": "string" },
    "resumo_executivo": {
      "type": "object",
      "required": ["riscos_top5","quick_wins_2_semanas"],
      "properties": {
        "riscos_top5": {
          "type": "array",
          "items": {"type":"object","required":["titulo","severidade","prioridade","impacto","evidencias"]}
        },
        "quick_wins_2_semanas": { "type": "array" }
      },
      "additionalProperties": false
    },
    "matriz_pontuacao": { "type":"object" },
    "achados_detalhados": { "type":"object" },
    "ddd_focus": { "type":"object" },
    "arquitetura": { "type":"object" },
    "testes_qualidade": { "type":"object" },
    "backlog_melhoria": { "type":"array" },
    "metadados": { "type":"object" }
  },
  "additionalProperties": false
}
```

## Instrução final de resposta
Após processar todos os batches automaticamente (ou parar por limite/falha global), responder somente com:
1) Um único JSON progress.json consolidado e válido cobrindo todos os itens processados;
2) Em seguida, um bloco ```diff com todos os patches aplicados na execução;
3) Em seguida, um bloco Markdown com o checklist.md final.
Se algum item estiver bloqueado por falta de evidência, registrar no progress.json com status "Blocked" e prosseguir automaticamente para os demais.

````
