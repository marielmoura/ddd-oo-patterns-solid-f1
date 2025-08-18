**Tarefa:** Crie uma classe de Serviço de Domínio chamada **[NomeDoServico]** que realize uma operação de negócio específica não atribuível a uma única Entidade.

**Objetivo:** Encapsular lógica de negócio que cruza múltiplas entidades/agregados (ex.: `CalcularEstrategiaDePitStop`, `AplicarPenalidadeDeTempo`). Sem dependências de Infra; dependa apenas de interfaces de repositório e objetos do domínio.

**Entregáveis:**
- Classe Java (sem package) `public class [NomeDoServico]`.
- Método principal com nome ubíquo (ex.: `calcular(...)`, `aplicar(...)`, `planejar(...)`).
- Teste mínimo validando caminho feliz e 1 borda (ex.: dados insuficientes, entidade inexistente).
- README curto explicando quando usar o serviço.

**Instruções:**
1) Declarar dependências via construtor sobre interfaces de repositório (DIP).
2) Orquestrar entidades/VOs; preservar invariantes; retornar resultado claro (VO/DTO de saída) quando aplicável.
3) Não lançar exceções genéricas; prefira `IllegalArgumentException` com mensagens claras ou exceções do domínio.
4) Não acessar tecnologias (DB, HTTP, Kafka); isso é responsabilidade da Infra.

**Critérios de Aceite:**
- Sem dependências de frameworks; somente domínio.
- Nomes e comportamento aderentes ao vocabulário da F1.
- Testes AAA cobrindo feliz + 1 borda.
