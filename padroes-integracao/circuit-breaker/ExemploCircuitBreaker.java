
// Exemplo simplificado: Circuit Breaker (didático, sem dependências)
import java.time.*;

interface ServicoClima {
	String previsao();
}

class ServicoClimaInstavel implements ServicoClima {
	private int chamadas = 0;

	public String previsao() {
		chamadas++;
		if (chamadas % 3 != 0)
			throw new RuntimeException("Falha transitória no serviço de clima");
		return "seco";
	}
}

class CircuitBreaker implements ServicoClima {
	private final ServicoClima alvo;
	private final int limiteFalhas;
	private final Duration timeoutHalfOpen;
	private int falhas = 0;
	private Estado estado = Estado.CLOSED;
	private Instant abertoAte = Instant.EPOCH;

	enum Estado {
		CLOSED, OPEN, HALF_OPEN
	}

	CircuitBreaker(ServicoClima alvo, int limiteFalhas, Duration timeoutHalfOpen) {
		this.alvo = alvo;
		this.limiteFalhas = limiteFalhas;
		this.timeoutHalfOpen = timeoutHalfOpen;
	}

	public String previsao() {
		avaliarTransicao();
		try {
			String resp = alvo.previsao();
			sucesso();
			return resp;
		} catch (RuntimeException e) {
			falha();
			throw e;
		}
	}

	private void sucesso() {
		falhas = 0;
		estado = Estado.CLOSED;
	}

	private void falha() {
		falhas++;
		if (falhas >= limiteFalhas) {
			estado = Estado.OPEN;
			abertoAte = Instant.now().plus(timeoutHalfOpen);
		}
	}

	private void avaliarTransicao() {
		if (estado == Estado.OPEN && Instant.now().isAfter(abertoAte)) {
			estado = Estado.HALF_OPEN;
		}
		if (estado == Estado.OPEN) {
			throw new RuntimeException("Circuito aberto");
		}
	}
}

public class ExemploCircuitBreaker {
	public static void main(String[] args) throws InterruptedException {
		ServicoClima instavel = new ServicoClimaInstavel();
		CircuitBreaker cb = new CircuitBreaker(instavel, 2, Duration.ofSeconds(1));
		for (int i = 0; i < 6; i++) {
			try {
				System.out.println("Previsão: " + cb.previsao());
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
			Thread.sleep(400);
		}
	}
}
