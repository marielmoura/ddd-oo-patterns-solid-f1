**Tarefa:** Criar um Evento de Domínio chamado **[NomeDoEvento]**.

**Contexto:** Evento imutável que comunica algo que ocorreu no domínio (ex.: `CarroQuebrou`, `VoltaConcluida`, `PenalidadeAplicada`). Sem dependências de infra.

**Instruções:**
1. Defina `public final class [NomeDoEvento]` com atributos essenciais (timestamp, agregados envolvidos, dados relevantes).
2. Imutável: campos `private final`, sem setters; forneça getters ou métodos de leitura com nomes ubíquos.
3. Construtor/fábrica estática valida pré-condições; mantenha mensagens de erro claras.
4. Inclua `toString()` informativo para logs e `equals/hashCode` quando fizer sentido.
5. Opcional: crie uma pequena interface `EventoDominio` com `quandoAconteceu()` se ainda não existir no contexto local.

**Critérios de Aceite:**
- Imutável; sem dependências de frameworks; nomes em Português.
- Carrega apenas informações necessárias; pronto para ser publicado/manuseado por listeners do domínio.
- Testes mínimos: construção válida e verificação de campos essenciais.
