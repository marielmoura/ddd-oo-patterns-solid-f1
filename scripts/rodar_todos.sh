#!/usr/bin/env bash
set -euo pipefail

# Roda smoke-tests: compila tudo e executa cada Exemplo*.java, salvando saída por arquivo
# Uso:
#   bash scripts/rodar_todos.sh

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
LOG_DIR="$ROOT_DIR/scripts/smoke-logs"
SUMMARY_FILE="$ROOT_DIR/scripts/smoke-summary.txt"

rm -rf "$LOG_DIR"
mkdir -p "$LOG_DIR"
: > "$SUMMARY_FILE"

# 1) Compila todos os diretórios
bash "$ROOT_DIR/scripts/compilar_todos.sh"

echo "Iniciando execução dos exemplos..."
echo "Iniciando execução dos exemplos..." >> "$SUMMARY_FILE"

TOTAL=0
FAILED=0

# 2) Encontra e executa todos os arquivos Exemplo*.java
# Iteração NUL-safe
while IFS= read -r -d '' f; do
  TOTAL=$((TOTAL+1))
  rel_path="${f#./}"
  dir="$(dirname "$f")"
  file="$(basename "$f")"
  main_class="${file%.java}"

  # Log file segue a mesma árvore de diretórios
  log_file="$LOG_DIR/$rel_path.out"
  mkdir -p "$(dirname "$log_file")"

  echo "[RUN] $rel_path"
  (
    cd "$dir"
    # Executa a classe principal (sem pacotes)
    echo "===> Executando $rel_path" > "$log_file"
    echo "--- SAIDA ---" >> "$log_file"
    if java "$main_class" >> "$log_file" 2>&1; then
      echo "PASS $rel_path" | tee -a "$SUMMARY_FILE"
    else
      echo "FAIL $rel_path" | tee -a "$SUMMARY_FILE"
      FAILED=$((FAILED+1))
    fi
  )

done < <(cd "$ROOT_DIR" && find . -type f -name 'Exemplo*.java' -print0)

echo "" | tee -a "$SUMMARY_FILE"
echo "TOTAL=$TOTAL, FAILED=$FAILED" | tee -a "$SUMMARY_FILE"

if [[ $FAILED -gt 0 ]]; then
  echo "Alguns exemplos falharam. Veja $SUMMARY_FILE e $LOG_DIR." >&2
  exit 1
else
  echo "Todos os exemplos executaram com sucesso. Logs em $LOG_DIR e resumo em $SUMMARY_FILE."
fi
