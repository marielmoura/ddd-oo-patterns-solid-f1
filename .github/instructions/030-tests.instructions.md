---
applyTo: "**/src/test/java/**/**.java"
---

# Testes (AAA, Cobertura e Estabilidade)

- AAA (Arrange, Act, Assert); independentes e determinísticos.
- JUnit 5, AssertJ, Mockito como padrão.
- Cobertura mínima nos arquivos tocados: ≥ 80%.
- `@WebMvcTest`/`WebTestClient` para web; `@DataJpaTest` para persistência.
- Evitar sleeps e dependência de ordem.

ALLOW_EDIT: src/test/java/**
DENY_EDIT: target/**, build/**, **/generated/**, **/*.min.*
