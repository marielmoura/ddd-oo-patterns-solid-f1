# Service Locator vs Injeção de Dependências (DI)

- Prefira DI: deixa dependências explícitas, facilita testes e segue DIP.
- Service Locator: oculta dependências e cria acoplamento ao localizador.
- Em Spring, use @Configuration/@Bean e @Component/@Service com construtores para DI.
