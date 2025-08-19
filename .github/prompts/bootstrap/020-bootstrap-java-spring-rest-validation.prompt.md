---
id: bootstrap-java-spring-rest-validation
mode: agent
applyTo: "src/main/**"
description: "Bootstrap REST Spring Boot com DTO/Bean Validation e testes"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

Objetivo: criar um módulo Spring Boot (Java 17) com endpoint REST `POST /{{resource}}` usando DTOs com Bean Validation, `@ControllerAdvice` para erros e testes web, garantindo cobertura com JaCoCo.

Contexto:
- Saída obrigatória: JSON `changeset` único válido por `schema/changeset.schema.json`.
- Stack: Maven, Spring Boot 3.x, Web, Validation, Spring Boot Starter Test; JaCoCo (check ≥ 0.80).
- DDD: domínio sem frameworks; controllers não expõem entidades do domínio; usar DTOs e mapeamento.
- Allow/Deny: respeitar guias do repo; não tocar em `target/**`, `build/**`, `**/generated/**`.

Parâmetros (assunções padrão se omitidos):
- `groupId = com.acme`
- `artifactId = rest-api`
- `package = com.acme.api`
- `modulePath = ${artifactId}`
- `resource = users` (ex.: cria `/users`)

Requisitos (checklist):
- [ ] `{{modulePath}}/pom.xml` com parent `spring-boot-starter-parent` (3.x) e dependências: `spring-boot-starter-web`, `spring-boot-starter-validation`, `spring-boot-starter-test` (escopo test). Incluir `jacoco-maven-plugin` com `prepare-agent` + `check` ≥ 0.80 ligado ao `verify`.
- [ ] Classe principal `src/main/java/{{packagePath}}/Application.java` com `@SpringBootApplication` e `main`.
- [ ] DTOs em `src/main/java/{{packagePath}}/api/dto/`:
  - `{{Resource}}CreateRequest` com campos: `name` (@NotBlank), `email` (@Email, @NotBlank).
  - `{{Resource}}Response` com campos: `id` (UUID), `name`, `email`.
- [ ] Controller `src/main/java/{{packagePath}}/api/{{Resource}}Controller.java` com `POST /{{resource}}`:
  - Recebe `@Valid {{Resource}}CreateRequest`, retorna `201 Created` com `Location: /{{resource}}/{id}` e body `{{Resource}}Response`.
- [ ] Error handler `src/main/java/{{packagePath}}/api/ErrorHandler.java` com `@ControllerAdvice` mapeando `MethodArgumentNotValidException` → `400` JSON:
  - shape: `{ "message": "validation failed", "errors": [{"field":"name","message":"must not be blank"}, ...] }`.
- [ ] (Domínio simples, sem frameworks) `src/main/java/{{packagePath}}/domain/{{Resource}}.java` (POJO) e um caso de uso `src/main/java/{{packagePath}}/application/Create{{Resource}}UseCase.java` que crie o objeto com `UUID.randomUUID()` e devolva DTO.
- [ ] Testes Web `src/test/java/{{packagePath}}/api/{{Resource}}ControllerTest.java` com `@WebMvcTest` + `MockMvc`:
  - happy path: 201 + Location + JSON body.
  - validação: payload inválido → 400 com lista de `errors` contendo `field` e `message`.
- [ ] `src/main/resources/application.yml` mínimo (porta default) apenas se necessário; não adicionar configs supérfluas.

Saída esperada:
- Um único bloco JSON `changeset` com arquivos completos e caminhos relativos dentro de `{{modulePath}}/`.
- `notes` com comandos de build/test.

Guardrails:
- Código e APIs públicas em inglês; logs sem PII; use injeção por construtor quando houver dependências.
- Não adicionar dependências além das citadas, a menos que justificado em `notes`.
- Não editar `DENY_EDIT`.

Critérios de aceite:
- `./mvnw -q -pl {{modulePath}} -am -DskipTests=false -DskipITs=false verify` passa.
- Testes verdes; cobertura JaCoCo ≥ 80% (goal `check`).
- `POST /{{resource}}` responde 201, Location correto e body conforme DTO; requisição inválida retorna 400 com shape especificado.

Assunções padrão:
- `packagePath` é `{{package}}` com `.` substituído por `/`.

Notas (incluir no campo `notes` do changeset):
- Comandos úteis:
```
./mvnw -q -pl {{modulePath}} -am -DskipTests=false -DskipITs=false verify
```
