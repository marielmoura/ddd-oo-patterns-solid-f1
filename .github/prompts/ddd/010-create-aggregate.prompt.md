---
id: ddd-create-aggregate
mode: agent
applyTo: "src/main/**"
description: "Cria um Aggregate raiz seguindo DDD, com testes e repositório"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

<!-- Prompt: Gerar um Agregado de Domínio -->
**Tarefa:** Crie um novo Agregado de Domínio chamado **[NomeDoAgregado]** que represente um conceito central do negócio de F1. Deve conter uma Entidade raiz **[NomeDoAgregado]** e entidades/value objects internos necessários.

**Contexto:** Utilize nomes em português e respeite a linguagem ubíqua (Corrida, Equipe, Carro, Box, Volta, Penalidade). Evite modelo anêmico; encapsule regras no agregado.

**Saída esperada (entregáveis):**
- Código Java autocontido (sem packages) para compilar neste repo.
- Arquivo(s): entidade raiz do agregado, pelo menos 1 VO/entidade interna, e a interface `Repositorio[NomeDoAgregado]`.
- Testes mínimos (feliz + 1 borda) validando invariantes e operações principais.
- README curto explicando o agregado, invariantes e exemplos de uso.

**Instruções:**
1) Defina `public class [NomeDoAgregado]` com identificador único (VO ou String) e atributos essenciais.
2) Implemente regras de negócio e invariantes dentro do agregado (Tell, Don’t Ask). Métodos com nomes ubíquos (ex.: `marcarPenalidade`, `agendarPitStop`, `registrarVolta`).
3) Inclua ao menos um Value Object ou entidade interna (ex.: `TempoVolta`, `PlanoPitStop`). VO deve ser imutável.
4) Valide invariantes nas operações; lance `IllegalArgumentException` com mensagens claras.
5) Forneça fábrica estática/Builder quando facilitar construção válida.
6) Crie interface `Repositorio[NomeDoAgregado]` com métodos orientados ao domínio (ex.: `porId(...)`, `salvar(...)`, `remover(...)`, `todosAtivos()`), sem detalhes de infra.
7) Documente no topo da classe as invariantes e regras relevantes.

**Contrato mínimo:**
- Entradas: dados essenciais do agregado; VO(s) relevantes.
- Saídas: estado consistente; retorno dos métodos quando aplicável.
- Erros: validações inválidas disparam `IllegalArgumentException`.

**Casos de borda:**
- Identificador nulo/vazio.
- Operações em estado inválido (ex.: marcar penalidade duplicada).
- Limites (ex.: tempo de volta negativo; combustível abaixo do mínimo).

**Critérios de Aceite:**
- Regras e invariantes no agregado, não em serviços anêmicos.
- VO imutável com `equals/hashCode` por valor.
- Repositório como interface orientada ao domínio.
- Testes AAA demonstrando comportamento e bordas.

Siga SOLID, DDD e Clean Code.
