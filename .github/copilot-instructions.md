# Instruções de Padrões do Repositório

- **Linguagem e Nomeação:** Todo código gerado deve usar identificadores em Português (linguagem ubíqua do domínio de F1). Nomes expressivos para classes, métodos e variáveis.
- **Modelo de Domínio Rico (evitar anêmico):** Centralize lógica nas entidades quando fizer sentido. Use Value Objects. Prefira Tell, Don’t Ask.
- **Camadas e Arquitetura DDD:**
  - Domínio: Entidades, Agregados, VOs, Serviços de Domínio, Repositórios (interfaces).
  - Aplicação: casos de uso, orquestra domínio, DTOs.
  - Infraestrutura: implementações técnicas (persistência, mensageria, APIs externas) e configurações.
  - Interface (UI/API): controllers REST, UI, CLI.
  Domínio não conhece frameworks. Use Injeção de Dependências (evitar Service Locator).
- **Princípios SOLID:** SRP, OCP, LSP, ISP, DIP. Use padrões (Factory, Strategy, Observer/Eventos, etc.) quando apropriado.
- **Qualidade e Clean Code:** Métodos curtos, nomes descritivos, remover duplicação, comentários para o "porquê". Consistência de estilo.
- **Testes e TDD:** Testes claros (AAA), usar Builders para cenários complexos, foco em comportamento. Cobertura alta nas regras críticas.
- **Documentação:** Atualizar READMEs e adicionar Javadoc quando necessário. Explicar quando/por que usar o padrão.

Observações:
- Prefira DI a Service Locator.
- Siga a organização por pastas descrita no README principal.
