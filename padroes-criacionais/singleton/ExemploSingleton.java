// Exemplo: Singleton - acesso único ao sistema de telemetria

class Telemetria {
	private static final Telemetria INSTANCIA = new Telemetria();

	private Telemetria() {
	}

	public static Telemetria get() {
		return INSTANCIA;
	}

	public void registrar(String msg) {
		System.out.println("[TEL] " + msg);
	}
}

public class ExemploSingleton {
	public static void main(String[] args) {
		Telemetria.get().registrar("Carro saiu para volta rápida");
		Telemetria.get().registrar("Diferença para P1: 0.032s");
	}
}
