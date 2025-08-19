---
id: ddd-create-test-builder
mode: agent
applyTo: "src/test/**"
description: "Cria um Test Data Builder para facilitar a criação de objetos de domínio em testes"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

**Tarefa:** Criar um Test Data Builder chamado **[NomeDoBuilder]** para a entidade/VO **[TipoAlvo]** do domínio.

**Objetivo:** Simplificar a criação de objetos válidos em testes, reduzindo repetição e deixando a intenção clara (Given/Arrange).

**Instruções:**
1. Classe pública `public class [NomeDoBuilder]` no pacote de testes (src/test/java/...).
2. Atributos privados com valores padrão válidos; métodos `withXxx(...)` retornam `this` (fluent API).
3. Método `build()` que cria e retorna uma instância válida de **[TipoAlvo]**. Não use frameworks; instancie diretamente.
4. Se o alvo tiver invariantes, mantenha padrões coerentes e forneça métodos para variar os campos relevantes.
5. Opcional: um atalho `public static [NomeDoBuilder] um[TipoAlvo]()` que retorna um builder com defaults.

**Critérios de Aceite:**
- Builder produz instâncias válidas por padrão.
- API fluente clara: `um[TipoAlvo]().withCampo(...).build()`.
- Teste mínimo provando: (a) defaults válidos; (b) customização de 1–2 campos; (c) borda simples (ex.: campo obrigatório ausente → exceção do domínio).
