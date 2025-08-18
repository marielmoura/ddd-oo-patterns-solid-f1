<!-- Prompt: Gerar um Agregado de Domínio -->
**Tarefa:** Crie um novo Agregado de Domínio chamado **[NomeDoAgregado]** que represente um conceito central do negócio de F1. Deve conter uma Entidade raiz **[NomeDoAgregado]** e entidades/value objects internos necessários.

**Contexto:** Utilize nomes em português e respeite a linguagem ubíqua (Corrida, Equipe, Carro, etc.). Evite modelo anêmico.

**Instruções:**
1. Defina `public class [NomeDoAgregado]` com identificador único e atributos essenciais.
2. Implemente regras de negócio dentro do agregado (métodos que manipulam seu estado e invariantes).
3. Inclua ao menos um Value Object ou entidade interna.
4. Garanta invariantes (validações) nos métodos.
5. Forneça fábrica estática ou Builder, se necessário.
6. Crie interface de Repositório `Repositorio[NomeDoAgregado]` com métodos orientados ao domínio.
7. Escreva um pequeno README do agregado.

Siga SOLID, DDD, e Clean Code.
