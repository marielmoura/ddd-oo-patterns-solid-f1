
// Exemplo: Proxy - cache simples de leituras de telemetria
import java.util.HashMap;
import java.util.Map;

interface TelemetriaServico {
	String ler(String canal);
}

class TelemetriaReal implements TelemetriaServico {
	public String ler(String canal) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ignored) {
		}
		return "valor-" + canal + "-" + (System.nanoTime() % 1000);
	}
}

class TelemetriaProxyCache implements TelemetriaServico {
	private final TelemetriaServico origem;
	private final Map<String, String> cache = new HashMap<>();

	TelemetriaProxyCache(TelemetriaServico origem) {
		this.origem = origem;
	}

	public String ler(String canal) {
		if (cache.containsKey(canal))
			return cache.get(canal);
		String v = origem.ler(canal);
		cache.put(canal, v);
		return v;
	}
}

public class ExemploProxy {
	public static void main(String[] args) {
		TelemetriaServico real = new TelemetriaReal();
		TelemetriaServico proxy = new TelemetriaProxyCache(real);
		String a1 = proxy.ler("velocidade");
		String a2 = proxy.ler("velocidade"); // cache deveria devolver igual
		String b1 = proxy.ler("rpm");
		System.out.println("velocidade #1: " + a1);
		System.out.println("velocidade #2 (cache): " + a2);
		System.out.println("rpm #1: " + b1);
		System.out.println("Cache funcionou: " + a1.equals(a2));
	}
}
