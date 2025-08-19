---
id: bootstrap-java-spring-web
mode: agent
applyTo: "src/main/**"
description: "Bootstrap de módulo Java/Spring Web com testes e JaCoCo"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

Objetivo: criar um novo módulo Java (Java 17) com layout `src/main/java` e `src/test/java`, testes mínimos e verificação de cobertura com JaCoCo.

Contexto:
- Saída obrigatória: JSON `changeset` válido por `schema/changeset.schema.json`.
- Stack: Maven, JUnit Jupiter 5, AssertJ, Mockito, JaCoCo (check ≥ 0.80).
- Allow/Deny: respeitar guias do repo; não tocar em `target/**`, `**/generated/**`, `build/**`.

Parâmetros (assunções padrão se omitidos):
- `groupId = com.acme`
- `artifactId = app`
- `package = com.acme.app`
- `modulePath = ${artifactId}`
- `springBoot = false`

Requisitos (checklist):
- [ ] Criar pasta `{{modulePath}}/` com `pom.xml` para Java 17.
- [ ] Dependências de teste: JUnit 5, AssertJ, Mockito.
- [ ] Plugin JaCoCo com `check` (linha ou instrução) ≥ 0.80 no `verify`.
- [ ] Código exemplo: `src/main/java/{{packagePath}}/App.java` com método `public String ping()` retornando "pong".
- [ ] Testes AAA: `src/test/java/{{packagePath}}/AppTest.java` cobrindo `ping()`; usar AssertJ.
- [ ] Se `springBoot = true`: adicionar Spring Boot 3.x (parent e starter), classe `Application`, endpoint `/actuator/health` opcional (ou `@RestController` com `/ping`), e teste com `@WebMvcTest`.

Saída esperada:
- Um único bloco JSON `changeset` com arquivos completos (sem reticências), caminhos relativos.
- Incluir `notes` com comandos de build/test e como rodar cobertura.

Guardrails:
- Código e APIs públicas em inglês; domínio sem frameworks (exceto se `springBoot = true`).
- Injeção por construtor (quando aplicável); não expor entidades do domínio em controllers.
- Não adicionar dependências além das listadas, a menos que justifique no `notes`.

Critérios de aceite:
- `./mvnw -q -pl {{modulePath}} -am -DskipTests=false -DskipITs=false verify` passa.
- Testes verdes; cobertura ≥ 80% (JaCoCo `check`).

Notas (incluir no campo `notes` do changeset):
- Comandos sugeridos:
```
./mvnw -q -pl {{modulePath}} -am -DskipTests=false -DskipITs=false verify
```
- Se `springBoot = true`, incluir instruções de `mvn spring-boot:run` para o módulo gerado.
