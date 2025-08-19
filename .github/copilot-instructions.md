# Instruções de Padrões do Repositório (para Copilot/Assistentes)

> Addendum para uso com assistentes (Copilot/LLMs): formato estruturado de resposta, contratos e validações automáticas.

## Objetivo

Padronizar como o assistente gera e altera código neste repositório, garantindo entregas consistentes, revisáveis e aplicáveis automaticamente.

## Escopo

* Java 17+, Spring Boot 3.x.
* Estilo de domínio (DDD), camadas, testes e contratos.
* Formato estruturado de resposta para múltiplos arquivos.

---

## 1) Linguagem, Nomeação e Estilo

* **Código e APIs públicas:** inglês.
* **Pacotes:** `com.acme.modulo.submodulo` (minúsculas, sem acentos).
* **Classes/Interfaces/Enums:** `PascalCase`.
* **Métodos/variáveis/campos:** `camelCase`.
* **Constantes:** `UPPER_SNAKE_CASE`.
* **Banco (se aplicável):** nomes em `snake_case` minúsculo; tabelas no singular ou plural consistente (definir e manter).
* **Commits:** Conventional Commits (`feat`, `fix`, `refactor`, `test`, `chore`, `build`, `docs`). Exemplos:

  * `feat(api): add POST /users with validation`
  * `fix(domain): prevent negative balance on debit`

**Eventos e mensageria**

* **Schema dos eventos:** inglês; campos `camelCase`; versionamento explícito (`.v1`, `.v2`).
* **Tópicos/Streams (PADRÃO OBRIGATÓRIO):** `namespace.resource-name.vN`

  * minúsculas; palavras com hífen; versão com sufixo `.vN`.
  * **Proibido** underscores; **proibido** misturar pontos além de separar o namespace e a versão.
  * Ex.: `billing.invoice-issued.v1`, `auth.password-reset.v1`.

---

## 2) DDD e Camadas

* **Domínio (puro):** entidades, agregados, VOs, serviços de domínio e invariantes **sem** anotações de frameworks.
* **Aplicação:** orquestra casos de uso; transações (`@Transactional`); mapeia DTO ↔ domínio; políticas de autorização.
* **Infraestrutura:** persistência (JPA), mensageria, web, storage; adapters para portas definidas no domínio/aplicação.
* **Interface (API/UI):** controllers, DTOs, validação de entrada/saída.
* **Regras:**

  * O domínio depende apenas de linguagem e do próprio domínio.
  * Controllers não expõem entidades do domínio; usar DTOs.
  * Injeção por construtor; **não** usar Service Locator ou singletons estáticos.

---

## 3) Código e Qualidade

* **Validação:** Bean Validation em DTOs; usar `@Valid` em controllers; invariantes no domínio.
* **Exceções:** mapear para respostas HTTP apropriadas; usar `@ControllerAdvice`.
* **Transações:** borda nos serviços de aplicação; evitar `@Transactional` em repositórios e no domínio.
* **Logging:** sem PII/segredos; usar SLF4J; níveis coerentes; correlação quando houver tracing.
* **Config:** `application.yml`; segredos fora do repo.
* **Observabilidade:** Micrometer; métricas HTTP/DB básicas quando aplicável.

**Allowlist/Denylist de arquivos para o assistente**

```
ALLOW_EDIT = [
  "src/main/java/**",
  "src/test/java/**",
  "pom.xml",
  "build.gradle",
  "build.gradle.kts",
  "settings.gradle*",
  "application*.yml",
  "application*.properties"
]
DENY_EDIT  = [
  "target/**",
  "build/**",
  "**/generated/**",
  "**/generated-sources/**",
  "**/*.min.*",
  "**/.idea/**",
  "**/.vscode/**"
]
```

---

## 4) Testes e Toolchain

* **Obrigatório:** JUnit Jupiter 5, AssertJ, Mockito.
* **Estilo:** AAA (Arrange, Act, Assert), testes determinísticos, sem depender de ordem.
* **Web:** `@WebMvcTest` + `MockMvc` ou `WebTestClient`.
* **Persistência:** `@DataJpaTest`; Testcontainers se disponível.
* **Cobertura mínima dos arquivos tocados:** 80% quando viável.

---

## 5) Formato de Resposta para Assistentes (múltiplos arquivos)

Responda com **um único bloco JSON** no formato `changeset`. O JSON deve validar contra `schema/changeset.schema.json`.

```json
{
  "changes": [
    {"path": "src/main/java/.../Foo.java", "action": "create|modify|delete", "content": "<código completo>"},
    {"path": "src/test/java/.../FooTest.java", "action": "create", "content": "<código completo>"}
  ],
  "notes": "objetivo, requisitos cobertos, casos de borda, instruções de build/test",
  "version": 1,
  "metadata": {"generatedBy": "assistant", "ts": "ISO-8601"}
}
```

**Regras do `changeset`**

* Forneça **arquivos completos**; não use reticências.
* Use caminhos relativos ao repo; **não** inclua `./` no meio do path.
* Inclua testes quando houver alteração de comportamento público.
* Não modifique arquivos fora do `ALLOW_EDIT` e nunca edite caminhos do `DENY_EDIT`.

### 5.1) Validação contra contratos

* Se existirem `openapi.yaml/json`, `asyncapi.yaml/json`, `schema/*.json|avsc`:

  * Validar nomes, caminhos, versões e tipos antes de propor mudanças.
  * Mudanças incompatíveis devem criar nova versão (`/v2`, `.v2`) e documentar migração.

---

## 6) Guardrails de Saída

* Não inventar endpoints, schemas ou tópicos.
* Não introduzir dependências sem justificativa e impacto.
* Preservar compatibilidade; se quebrar, versionar.
* Evitar refactors amplos fora do escopo do pedido.
* Não inserir segredos/PII.
* Respeitar estrutura de pastas e scripts existentes.
* **Domínio sem frameworks**; **DTOs com validação**; **injeção por construtor**.

---

## 7) Checklist Final

* [ ] Código e APIs em inglês; nomeação correta.
* [ ] Domínio sem frameworks; invariantes cobertas.
* [ ] DTOs com Bean Validation; controllers com `@Valid`.
* [ ] Transações na camada de aplicação; exceções mapeadas.
* [ ] Testes JUnit 5 + AssertJ + Mockito; casos de borda; cobertura ≥ 80% nos arquivos tocados.
* [ ] Eventos versionados e tópicos no padrão `namespace.resource-name.vN`.
* [ ] Contratos (OpenAPI/AsyncAPI/Schema) validados.
* [ ] Resposta em formato `changeset` válida pelo schema.

---

## Apêndice A — Exemplo mínimo de `changeset`

```json
{
  "changes": [
    {
      "path": "src/main/java/com/acme/user/api/UserController.java",
      "action": "modify",
      "content": "package com.acme.user.api;\n\nimport jakarta.validation.Valid;\nimport org.springframework.http.ResponseEntity;\nimport org.springframework.web.bind.annotation.*;\n\n@RestController\n@RequestMapping(\"/users\")\npublic class UserController {\n  @PostMapping\n  public ResponseEntity<String> create(@Valid @RequestBody UserRequest req) {\n    return ResponseEntity.ok(\"ok\");\n  }\n}\n"
    },
    {
      "path": "src/test/java/com/acme/user/api/UserControllerTest.java",
      "action": "create",
      "content": "package com.acme.user.api;\n\nimport org.junit.jupiter.api.Test;\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;\nimport org.springframework.test.web.servlet.MockMvc;\n\nimport static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;\nimport static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;\n\n@WebMvcTest(UserController.class)\nclass UserControllerTest {\n  @Autowired MockMvc mvc;\n  @Test void rejectsInvalidPayload() throws Exception {\n    mvc.perform(post(\"/users\").contentType(\"application/json\").content(\"{}\"))\n       .andExpect(status().isBadRequest());\n  }\n}\n"
    }
  ],
  "notes": "Validação mínima em /users; teste de 400."
}
```

---

# schema/changeset.schema.json

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "title": "changeset",
  "type": "object",
  "required": ["changes"],
  "properties": {
    "changes": {
      "type": "array",
      "minItems": 1,
      "items": {
        "type": "object",
        "required": ["path", "action"],
        "properties": {
          "path": {
            "type": "string",
            "minLength": 1,
            "pattern": "^(?!\\.\\/|\\/)(?!.*\\.\\.\\/)[A-Za-z0-9_.\\-\/]+$"
          },
          "action": {
            "type": "string",
            "enum": ["create", "modify", "delete"]
          },
          "content": { "type": "string" }
        },
        "additionalProperties": false,
        "allOf": [
          {
            "if": { "properties": { "action": { "const": "delete" } }, "required": ["action"] },
            "then": { "not": { "required": ["content"] } }
          },
          {
            "if": { "properties": { "action": { "enum": ["create", "modify"] } }, "required": ["action"] },
            "then": { "required": ["content"] }
          }
        ]
      }
    },
    "notes": { "type": "string" },
    "version": { "type": "integer", "minimum": 1 },
    "metadata": {
      "type": "object",
      "properties": {
        "generatedBy": { "type": "string" },
        "ts": { "type": "string", "format": "date-time" }
      },
      "additionalProperties": true
    }
  },
  "additionalProperties": false
}
```
