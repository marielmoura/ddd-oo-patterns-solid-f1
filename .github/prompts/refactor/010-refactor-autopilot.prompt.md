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

Passos por batch:
1) Selecionar até N itens do backlog com prioridades Must/Should e severidade S0–S2.
2) Para cada item:
   - Criar/atualizar testes primeiro (AAA, nomes claros). Se for refactor puro, assegurar testes de caracterização.
   - Implementar a mudança mínima para passar os testes e atender o critério de pronto do item.
   - Se alterar APIs públicas, atualizar docs/contratos relevantes (OpenAPI, README).
   - Rodar build/test/lint e coletar cobertura (objetivo ≥ 80% nos arquivos tocados).
3) Produzir changeset JSON com um commit lógico por item (mensagem Conventional Commits: `refactor(scope): resumo` ou `fix(scope): resumo`).
4) Atualizar progress.json (aderente ao schema) com checklist e status por item.

Saídas por batch:
- changeset (arquivos completos)
- progress.json com:
  - batch_id, itens_processados[], checklist_markdown, proximos_passos[]

Validação:
- Rodar `mvn -q -DskipTests=false verify` ou equivalente.
- Se falhar, corrija até 3 tentativas. Persistindo a falha, marque o item como Blocked e siga para o próximo.

Notas de segurança:
- Nunca incluir segredos em configs ou logs; mascarar tokens.
- Sanitizar logs, mapear corretamente erros para não vazar detalhes sensíveis.
````
