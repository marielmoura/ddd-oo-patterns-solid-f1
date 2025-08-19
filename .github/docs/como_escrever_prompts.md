# 1) Guia de Escrita de Prompts (convenções)

Use esta estrutura ao criar novos prompts neste repositório.

Objetivo (1–2 frases): o que será produzido e por quê.

Contexto mínimo: tecnologias, contratos existentes (OpenAPI/AsyncAPI/Schema), arquivos-alvo, ALLOW_EDIT/DENY_EDIT, restrições (DDD/SOLID, idioma, domínio sem frameworks).

Requisitos em checklist: itens acionáveis e verificáveis.

Saída esperada:

Preferencial: JSON changeset válido em schema/changeset.schema.json (múltiplos arquivos).

Alternativa: Markdown com artefatos completos + checklist.

Sempre que alterar comportamento público: testes e instruções de build.

Guardrails: linguagem/casing por categoria; não introduzir dependências sem justificativa; segurança/PII; versionamento de APIs/eventos.

Critérios de aceite: comportamento esperado, invariantes, DIP via interfaces, comandos de verificação (build/lint/test) e cobertura mínima para arquivos tocados.

Exemplos pequenos (opcional): 1 correto e 1 incorreto.

Perguntas de esclarecimento (somente se bloqueado): no máximo 1–2, objetivas. Se perguntar, proponha assunção padrão e continue.

Tonalidade: direta, concisa, orientada à ação. Evitar jargão e repetição.

ALLOW_EDIT: src/main/java/**, src/test/java/**, pom.xml, build.gradle*, settings.gradle*, application*.yml|properties

DENY_EDIT: target/**, build/**, **/generated/**, **/*.min.*, **/.idea/**, **/.vscode/**

---

# 2) Disciplina de Resposta do Agente (execução)

Extraia requisitos e mantenha um checklist visível até o fim.

Faça no máximo 2 assunções para destravar, documente no início.

Trabalhe em lotes pequenos: até 3–5 arquivos ou 3–5 ações antes de um checkpoint.

Antes de cada lote: antecipe o que será rodado e resultado esperado em 1 frase.

Em checkpoint: relate deltas e próximo passo. Se falhar build/lint/test, corrija ou reverta o lote.

Qualidade antes de concluir: build, lint/typecheck (se aplicável), testes mínimos e um smoke.

Commits: um por lote, Conventional Commits com escopo e referência do item.

Fail-fast: se 2 checkpoints seguidos falharem na validação, parar e emitir relatório do que ficou pendente.

Quando usar exemplos: trechos essenciais e caminhos reais do repo.

---

# 3) Rubrica de Auto-Checagem (30s)

Linguagem/casing aderentes à matriz? (APIs/eventos/DB em inglês; domínio PT-BR sem acentos)

DDD/camadas respeitadas? (domínio sem frameworks; DIP por interfaces; DTO ≠ entidade)

Requisitos → status mapeados? Nada ficou de fora?

Segurança/privacidade atendida? (sem segredos/PII; mascarar quando necessário)

Versionamento/compat de APIs/eventos verificado? (.v1, retrocompatibilidade)

Permissões de edição respeitadas? (apenas ALLOW_EDIT, nunca DENY_EDIT)

Build/test passam com os scripts do repo? Cobertura ≥ 80% nos arquivos tocados? Documentação atualizada?

---

# Mini-template de prompt (para colar em .prompt.md)

---
mode: agent
description: "Gerar funcionalidade X com testes e changeset estruturado"
applyTo: "src/**"
---

Objetivo: implementar {{feature}} em {{stack}}, conforme contratos existentes.

Contexto:
- Contratos: #openapi.yaml
- Allow/Deny: ver guia do repo
- Restrições: DDD (domínio puro), DIP, idioma EN em APIs

Requisitos (checklist):
- [ ] Endpoints/eventos conforme contratos
- [ ] DTOs com Bean Validation e mapeamento
- [ ] Testes (fluxo feliz + bordas) e cobertura ≥ 80% nos arquivos tocados
- [ ] Logs sem PII; erros mapeados

Saída esperada:
- **JSON `changeset`** válido no `schema/changeset.schema.json`
- Notas com comandos de build/test

Guardrails:
- Sem deps novas sem justificativa e impacto
- Não tocar em `DENY_EDIT`

Critérios de aceite:
- `mvn -q -DskipTests=false verify` ok
- Testes passam; linters sem novas violações
- Contratos verificados

Se bloqueado:
- Faça até 2 perguntas objetivas e sugira assunção padrão para seguir.
