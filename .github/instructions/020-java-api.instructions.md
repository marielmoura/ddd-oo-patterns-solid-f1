applyTo:
	- "**/src/main/java/**/api/**/*.java"
	- "**/src/main/java/**/controller/**/*.java"
---

# Java API Instructions (Controllers/DTO/Validation)

- Controllers não expõem entidades do domínio; use DTOs e mapeamento claro.
- Bean Validation em DTOs; `@Valid` nos endpoints.
- Erros: mapear via `@ControllerAdvice` para códigos HTTP adequados.
- Versione APIs quebrando compat: `/v2`.
- Logs sem PII; mascarar identificadores sensíveis.
- Idioma: inglês.

ALLOW_EDIT: src/main/java/**, src/test/java/**
DENY_EDIT: target/**, build/**, **/generated/**, **/*.min.*
