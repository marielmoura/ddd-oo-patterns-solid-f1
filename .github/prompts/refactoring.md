# Prompt VS Code Agent — Correção Gradual com Checklist (Java/Spring)

Este prompt transforma achados **fracos** e **críticos** do seu relatório (JSON) em correções graduais, validadas por testes, com commits e checklist de progresso dentro do VS Code.

---

## Como usar

1. Tenha um `analysis.json` (saída do seu analisador) e o repositório Java/Spring aberto no VS Code.
2. Cole **o prompt abaixo** no agente do VS Code (ex.: Copilot Chat) junto com o caminho do `analysis.json` ou cole o JSON em seguida.
3. Se não existir, o agente gera `backlog.json` priorizando S0–S2 e Must/Should.
4. **Modo Autônomo**: o agente trabalha em **lotes de até 3 itens por batch**, repete automaticamente até esgotar o backlog ou atingir limites de segurança, gerando `progress.json` incremental, patches (diff) e `checklist.md` consolidado.

5) Se ainda houver itens e limites não foram atingidos, **voltar ao passo 2 automaticamente**.

DETECÇÃO DE BUILD

* Se existir `pom.xml` → Maven. Se existir `build.gradle[.kts]` → Gradle. Use o que for encontrado.

COMANDOS DE VALIDAÇÃO

* Maven:

  * `mvn -q -DskipTests=false -DfailIfNoTests=false test`
  * `mvn -q -DskipTests=false verify`
  * Se plugins presentes em `pom.xml`, executar: `spotless:apply` `checkstyle:check` `spotbugs:check` `pmd:check`
* Gradle:

  * `./gradlew test`
  * `./gradlew check`
* Integração (se perfil existir): `mvn -q -P it verify` ou `./gradlew integrationTest`

SAÍDAS OBRIGATÓRIAS

1. **progress.json**: objeto JSON seguindo o esquema abaixo.
2. **Patches**: bloco(s) `diff` com alterações.
3. **checklist.md**: checklist Markdown com \[x]/\[ ] dos itens trabalhados.

MAPEAMENTO `analysis.json` → `backlog.json`

* Para cada item em `backlog_melhoria` com `prioridade ∈ {Must,Should}` e `severidade ∈ {S0,S1,S2}`:

  * `id`: usar existente se houver; senão gerar `${TOPICO}-${contador}` (ex.: `SEC-001`).
  * `topico`: copiar de `topico`.
  * `titulo`: copiar de `item`.
  * `descricao`: sumarizar recomendações.
  * `severidade`, `prioridade`, `effort`: copiar.
  * `arquivos_alvo`: a partir de `evidencias` dos achados ou vazio.
  * `criterios_de_pronto`: derivados de `recomendacoes` e riscos.
  * `estado`: "Todo".

ESQUEMA `backlog.json`
{
"itens": \[
{
"id": "SEC-001",
"topico": "Seguranca",
"titulo": "Enforce Bean Validation nos DTOs de entrada",
"descricao": "Adicionar @Valid/@Validated em controllers e constraints em DTOs",
"prioridade": "Must",
"severidade": "S2",
"effort": "S",
"arquivos\_alvo": \["src/main/java/.../UserController.java", "src/main/java/.../UserRequest.java"],
"criterios\_de\_pronto": \[
"Controllers anotados com @Validated/@Valid",
"DTOs com @NotNull/@Size conforme regras",
"Teste falha quando constraint é violada"
],
"estado": "Todo",
"dependencias": \[],
"evidencias": \[]
}
],
"metadados": { "gerado\_de": "analysis.json", "data": "ISO-8601" }
}

ESQUEMA **progress.json** (SAÍDA)
{
"batch\_id": "<ISO-8601>",
"itens\_processados": \[
{
"id": "SEC-001",
"antes\_resumo": "Controller aceita payloads inválidos",
"depois\_resumo": "Validação aplicada e testada",
"status": "Done|NeedsReview|Blocked",
"arquivos\_modificados": \["path1","path2"],
"novos\_testes": \["pathTest1"],
"comando\_validacao": \["mvn -q test"],
"resultado\_validacao": { "sucesso": true, "tests\_passed": 42, "tests\_failed": 0 },
"commit": { "hash": "<hash>", "mensagem": "feat(validation): enforce Bean Validation on User endpoints (#SEC-001)" },
"observacoes": ""
}
],
"checklist\_markdown": "- \[x] SEC-001 Enforce Bean Validation...\n- \[ ] ARQ-003 Corrigir ciclo de dependência...",
"proximos\_passos": \["id1", "id2", "id3"]
}

FORMATO DOS PATCHES (OBRIGATÓRIO)

* Use **diff unificado**:
  \--- a/src/main/java/.../UserController.java
  +++ b/src/main/java/.../UserController.java
  @@
* public ResponseEntity<User> create(@RequestBody UserRequest req) {

- public ResponseEntity<User> create(@Valid @RequestBody UserRequest req) {
  // ...
  }

CRITÉRIOS DE VALIDAÇÃO POR ITEM

* Todos os `criterios_de_pronto` atendidos.
* Todos os testes passam.
* Análises estáticas não introduzem novos erros.
* Cobertura dos arquivos tocados ≥ 80% quando viável.

FLUXO

1. Carregar ou gerar `backlog.json` a partir de `analysis.json`.
2. Selecionar até **3 itens elegíveis** (sem dependências pendentes).
3. Para cada item: **planejar → aplicar patch → testes → validação → commit → atualizar backlog**.
4. Emitir **progress.json**, **patches** e **checklist.md**.
5. Parar.

INSTRUÇÃO FINAL DE RESPOSTA
Após processar **todos os batches automaticamente** (ou parar por limite/falha global), responda **somente** com:

1. Um único JSON `progress.json` **consolidado** cobrindo todos os itens processados;
2. Em seguida, um bloco \`\`\`diff com **todos** os patches aplicados na execução;
3. Em seguida, um bloco Markdown com o `checklist.md` **final**.
   Se algum item estiver bloqueado por falta de evidência, registre no `progress.json` com \`status":"Blocked" e prossiga automaticamente para os demais.
