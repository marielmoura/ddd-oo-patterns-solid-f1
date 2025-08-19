---
id: analysis-java-spring
mode: agent
applyTo: "src/main/**"
description: "Analisar projeto Java/Spring e produzir analysis.json/md conforme schema"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

````prompt
Você é um Arquiteto de Software Sênior especialista em Java (>=17) e Spring Boot (>=3.x). Produza uma ANÁLISE TÉCNICA COMPLETA do projeto abaixo.

Contexto do projeto (preencha):
- Nome/descrição: {{resumo_do_produto}}
- Domínio do problema: {{dominio}}
- Stack: Java {{java_version|17}}, Spring Boot {{spring_boot_version|3.3}}, Build {{build_tool|Maven}}, DB {{db|PostgreSQL}}, JPA {{jpa|Hibernate/Spring Data JPA}}, Mensageria {{mensageria|n/a}}, Observabilidade {{obs|Micrometer + Prometheus + Logback}}, Infra {{infra|Docker}}
- Arquitetura atual: {{monolito_microservicos_modulos}}
- Integrações externas: {{apis_integracoes}}
- Requisitos críticos: {{sla_slo_perf_conformidade}}
- Artefatos fornecidos: {{repos_arquivos_trechos_diagramas_pipelines}}

Escala:
- Severidade: S0 bloqueante, S1 crítico, S2 alto, S3 médio, S4 baixo, S5 cosmético
- Prioridade: MoSCoW [Must, Should, Could, Won’t]
- Rubrica de pontuação (0–5) para a Matriz de Pontuação: 0 inexistente | 1 incipiente | 2 abaixo do mínimo | 3 adequado | 4 bom | 5 excelente. Critério: evidências + impacto no risco + abrangência.

Escopo da avaliação (para cada tópico: pontos fortes, fracos e críticos, com evidências e recomendações acionáveis):
1) SOLID
2) Programação Orientada a Objetos
3) Domain-Driven Design
4) Padrões de Projeto
5) Arquitetura Limpa
6) Código Limpo
7) Segurança (mapear para OWASP Top 10 e ASVS nível {{asvs|2}})

Regras:
- Seja específico: referencie arquivo e linha quando possível. Se faltar evidência, marque “inconclusivo” e liste “insumo_necessario”.
- Forneça exemplos “antes/depois” curtos quando recomendar mudança.
- Considere trade-offs de desempenho, custo e complexidade.
- Em Segurança, cubra: autenticação, autorização, validação, serialização, erros, segredos, logging, transporte, armazenamento, cabeçalhos, CORS/CSRF.
- Em Java/Spring, verifique: camadas e acoplamento, ciclos de dependência, uso de @Transactional, escopo de beans, DTO vs entidade no controller, validação Bean Validation, padrões em Services/Repositories, exceções, configuração (application.yml), Lombok/records, Testcontainers, MockMvc/WebTestClient.
- Salve dois arquivos na raiz do projeto com os mesmos dados:
  - analysis.json: conter apenas JSON válido, exatamente no formato abaixo.
  - analysis.md: conter a mesma informação em Markdown, mais legível, seguindo o template abaixo.
  - Validação do JSON: após gerar o analysis.json, valide se o conteúdo é JSON estrito válido (UTF-8, sem comentários) e aderente ao “Formato de saída (JSON)”. Se mal formatado ou com campos/chaves fora do especificado, corrija e revalide antes de salvar.
  - Validar contra o schema analysis.schema.json (na raiz do repositório), se presente.
  - Gerar um content_hash (ex.: SHA-256 do conteúdo canônico do JSON) em analysis.json e replicar o mesmo valor no topo do analysis.md para revisão humana.
  - Paths: não use "./" no meio dos caminhos (ex.: prefira "src/main/java/.../UserController.java" em vez de "src/main/java/./UserController.java").

Formato de saída (JSON) — salvar como ./analysis.json:
{ ... }

Template de saída (Markdown) — salvar como ./analysis.md:
# Resumo Executivo
...
````
