---
id: ddd-create-application-usecase
mode: agent
applyTo: "src/main/**"
description: "Cria um Caso de Uso de Aplicação que orquestra o domínio"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

**Tarefa:** Criar um Caso de Uso de Aplicação chamado **[NomeDoCasoDeUso]**.

**Objetivo:** Orquestrar o domínio para realizar uma ação de negócio ponta‑a‑ponta (sem detalhes de Infra). Ex.: `SelecionarVoo`, `PlanejarPitStop`, `CriarPacoteViagem`.

**Entregáveis:**
- Classe Java (sem package) `public class [NomeDoCasoDeUso]`.
- Um comando de entrada (ex.: `public static final class Comando { ... }`) validado.
- Um resultado/DTO de saída (ex.: `public static final class Resultado { ... }`).
- Testes mínimos (feliz + 1 borda) e README curto com exemplo de uso.

**Instruções:**
1) Dependências via construtor para interfaces de repositório e serviços de domínio (DIP).
2) Método principal (ex.: `executar(Comando cmd)`) que:
   - Valida o `Comando` (pré‑condições) e falha com `IllegalArgumentException` clara.
   - Carrega entidades via repositórios (interfaces) e invoca métodos do domínio (Tell, Don’t Ask).
   - Garante invariantes de negócio e retorna `Resultado` explícito.
3) Sem frameworks nem IO (DB/HTTP/Kafka). Implementações concretas ficam na Infra.
4) Nomear membros conforme linguagem ubíqua (F1).

**Contrato mínimo:**
- Entrada: `Comando` completo e validado.
- Saída: `Resultado` com dados essenciais para o chamador.
- Erros: mensagens claras; não capturar/ocultar erros de domínio.

**Casos de borda (exemplos):**
- Identificadores inexistentes.
- Dados inconsistentes no `Comando`.
- Conflitos de estado (ex.: operação já aplicada).

**Critérios de Aceite:**
- Orquestra apenas; regras continuam no domínio.
- Dependências são interfaces; sem anotações/frameworks.
- Testes AAA (feliz + 1 borda) cobrindo o fluxo.
