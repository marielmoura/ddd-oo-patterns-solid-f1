---
applyTo: "**/*.java"
---

# Security & Events Instructions

- Eventos em inglês; `camelCase` e versão `.vN` no nome do tópico: `namespace.resource-name.v1`.
- Validar contratos (OpenAPI/AsyncAPI/Schema) e manter retrocompatibilidade; se quebrar, versionar.
- Nunca incluir PII em logs/payloads; mascarar quando necessário.

ALLOW_EDIT: src/main/java/**, src/test/java/**
DENY_EDIT: target/**, build/**, **/generated/**, **/*.min.*
