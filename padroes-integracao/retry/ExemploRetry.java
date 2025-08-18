
// Exemplo didático: Retry com backoff simples
import java.util.concurrent.ThreadLocalRandom;

interface ClienteClima {
	String previsao();
}

class ClienteClimaFlaky implements ClienteClima {
	public String previsao() {
		if (ThreadLocalRandom.current().nextInt(100) < 70)
			throw new RuntimeException("falha transitória");
		return "nublado";
	}
}

class RetryExecutor {
	private final int maxTentativas;
	private final long backoffMs;

	RetryExecutor(int maxTentativas, long backoffMs) {
		this.maxTentativas = maxTentativas;
		this.backoffMs = backoffMs;
	}

	public <T> T executar(Chamada<T> chamada) {
		int tentativas = 0;
		RuntimeException ultima = null;
		while (tentativas < maxTentativas) {
			try {
				return chamada.call();
			} catch (RuntimeException e) {
				ultima = e;
				tentativas++;
				try {
					Thread.sleep(backoffMs * tentativas);
				} catch (InterruptedException ignored) {
				}
			}
		}
		throw ultima != null ? ultima : new RuntimeException("falha");
	}

	interface Chamada<T> {
		T call();
	}
}

public class ExemploRetry {
	public static void main(String[] args) {
		ClienteClima api = new ClienteClimaFlaky();
		RetryExecutor retry = new RetryExecutor(4, 150);
		String previsao = retry.executar(api::previsao);
		System.out.println("Previsão: " + previsao);
	}
}
