**Tarefa:** Criar um Builder de Teste chamado **[NomeDoBuilder]** para facilitar a criação de objetos do domínio.

**Objetivo:** Padronizar dados default válidos e permitir variações fluentes em testes AAA.

**Instruções:**
1) Classe Java (sem package) `public class [NomeDoBuilder]` com:
   - Campos privados com defaults válidos.
   - Métodos fluentes `comX(...)` para sobrescrever valores.
   - `public [Tipo] construir()` que aplica validações do domínio e retorna o objeto pronto.
2) Sem dependências de frameworks; somente domínio.
3) Fornecer exemplo de uso no topo do arquivo (comentário) e cenários comuns (ex.: `valido()`, `invalido()` quando fizer sentido).

**Critérios de Aceite:**
- Facilita escrita de testes AAA; reduz duplicação.
- Nomes em Português; linguagem ubíqua.
- Mantém o domínio válido (não burlar invariantes inadvertidamente).
