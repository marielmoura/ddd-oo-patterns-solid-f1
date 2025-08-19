**Tarefa:** Crie uma interface de Repositório do Domínio para a entidade **[Entidade]**.

**Objetivo:** Expor operações orientadas ao negócio para recuperar e persistir **[Entidade]**, sem detalhes técnicos (JPA/DAO). A implementação fica na camada de Infra.

**Instruções:**
- Nome: `Repositorio[Entidade]`.
- Assinaturas orientadas ao domínio; exemplos:
	- `Optional<[Entidade]> porId([IdTipo] id)`
	- `void salvar([Entidade] entidade)`
	- `void remover([Entidade] entidade)`
	- Consultas ubíquas (ex.: `todosAtivos()`, `porEquipe(String nomeEquipe)`, `ultimasPorCorrida(String corridaId)`).
- Não expor coleções mutáveis diretamente; prefira `List` imutável ou documente contrato.
- Não incluir anotações/frameworks; apenas interface.

**Critérios de Aceite:**
- Métodos refletem linguagem do domínio; sem termos técnicos de infra.
- DIP: dependências fluem para interfaces; domínio não conhece implementação.
- Documentação curta explicando propósito e cada método rapidamente.
