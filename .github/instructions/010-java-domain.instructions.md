---
applyTo: "**/*.java"
---

# Java Domain Instructions (DDD puro)

- Domínio sem frameworks: entidades, agregados, VOs e serviços de domínio não devem ter anotações de Spring/JPA.
- Invariantes no domínio; construtores/métodos fábricas garantem estado válido.
- Dependências para fora do domínio via interfaces (DIP). Implementações ficam em infraestrutura.
- Nomeação: classes/Enums em PascalCase; métodos/campos em camelCase; pacotes minúsculos.
- Idioma do código: inglês; domínio PT-BR apenas em comentários se necessário.
- Proibido expor entidades do domínio em APIs.

ALLOW_EDIT: src/main/java/**, src/test/java/**
DENY_EDIT: target/**, build/**, **/generated/**, **/*.min.*
