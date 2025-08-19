---
id: ddd-create-value-object
mode: agent
applyTo: "src/main/**"
description: "Cria um Value Object imutável com invariantes e testes"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

**Tarefa:** Criar um Value Object (VO) chamado **[NomeDoVO]**.

**Contexto:** VO imutável que representa um conceito do domínio F1 (ex.: `CpfPiloto`, `TempoVolta`, `PotenciaMotor`). Deve validar invariantes na criação.

**Instruções:**
1. Defina `public final class [NomeDoVO]` com campos `private final`.
2. Construtor/fábrica estática valida invariantes e lança `IllegalArgumentException` com mensagem clara.
3. Imutável: sem setters; com métodos de valor (e.g., `valor()`, `toString()`), `equals`/`hashCode` baseados no(s) campo(s) de valor.
4. Forneça operações de domínio relevantes (ex.: somar tempos, comparar potências) mantendo imutabilidade.
5. Documente invariantes no Javadoc.

**Critérios de Aceite:**
- Imutável, invariantes validadas, `equals/hashCode` corretos.
- Nomes em Português e aderência ao domínio.
- Testes mínimos: construção válida/ inválida e 1 operação de domínio.
