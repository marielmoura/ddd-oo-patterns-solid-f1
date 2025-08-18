## 1) Guia de Escrita de Prompts (convenções)

Use esta estrutura ao criar novos prompts neste repositório, sem perder as diretrizes acima.

- Objetivo (1–2 frases): descreva o que será produzido e por quê.
- Contexto mínimo: tecnologias, arquivos-alvo, restrições (DDD/SOLID, idioma, sem frameworks no domínio).
- Requisitos em checklist: itens acionáveis que não podem ser perdidos.
- Saída esperada: formato, arquivos a criar/editar, testes, README.
- Guardrails: linguagem/casing por categoria, não introduzir deps sem justificativa, segurança/PII, versionamento de APIs/eventos.
- Critérios de aceite: comportamento esperado, invariantes, DIP, testes AAA.
- Exemplos pequenos (opcional): 1 exemplo correto e 1 incorreto.
- Perguntas de esclarecimento (somente se bloqueado): no máximo 1–2, objetivas.

Tonalidade: amigável, concisa, orientada à ação. Evitar jargão desnecessário e repetições.

Anti‑padrões a evitar:
- “Inventar” endpoints/esquemas/tópicos/paths; sempre validar contra o repo.
- Adicionar bibliotecas sem justificativa e impacto.
- Responder longo sem entregar artefatos ou sem checklist de requisitos.
- Ignorar build/test; não deixar o projeto quebrado.

---

## 2) Disciplina de Resposta do Agente (execução)

- Extraia requisitos do pedido e mantenha um checklist visível até o fim.
- Faça suposições mínimas (1–2) apenas quando destravam o fluxo e registre-as.
- Ao editar/criar > ~3 arquivos ou após 3–5 ações, faça um checkpoint curto (o que mudou e próximo passo).
- Em lotes de ações, antecipe com 1 frase o que vai rodar e o resultado esperado.
- Relate deltas, não repita planos inalterados.
- Qualidade antes de concluir: Build, Lint/Typecheck (se aplicável), Testes mínimos e um smoke.

Quando usar exemplos: prefira trechos essenciais e aponte para arquivos reais do repo.

---

## 3) Rubrica de Auto‑Checagem (30s)

- Linguagem/casing aderentes à matriz e exemplos? (APIs/eventos/DB em inglês; domínio PT‑BR sem acentos)
- DDD camadas respeitadas? (domínio sem frameworks; DIP via interfaces)
- Requisitos → status mapeados? Nada ficou de fora?
- Segurança/privacidade atendida? (sem segredos/PII; mascarado quando necessário)
- Versionamento/compat de APIs/eventos verificado? (.v1, retrocompatibilidade)
- Build/test executam com os scripts do repo? Documentação atualizada?