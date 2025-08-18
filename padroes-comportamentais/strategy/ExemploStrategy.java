// Exemplo: Strategy para escolha de estratégia de pneus

interface EstrategiaPneus {
	String decidirProximoStint(int voltasRestantes, boolean safetyCar, String clima);
}

class EstrategiaAgressiva implements EstrategiaPneus {
	public String decidirProximoStint(int voltasRestantes, boolean safetyCar, String clima) {
		if (clima.equalsIgnoreCase("chuvoso"))
			return "intermediario";
		return voltasRestantes <= 12 ? "macio" : "medio";
	}
}

class EstrategiaConservadora implements EstrategiaPneus {
	public String decidirProximoStint(int voltasRestantes, boolean safetyCar, String clima) {
		if (safetyCar)
			return "medio";
		return voltasRestantes >= 25 ? "duro" : "medio";
	}
}

class EngenheiroCorrida {
	private EstrategiaPneus estrategia;

	public EngenheiroCorrida(EstrategiaPneus estrategia) {
		this.estrategia = estrategia;
	}

	public void setEstrategia(EstrategiaPneus estrategia) {
		this.estrategia = estrategia;
	}

	public String decidir(int voltasRestantes, boolean safetyCar, String clima) {
		return estrategia.decidirProximoStint(voltasRestantes, safetyCar, clima);
	}
}

public class ExemploStrategy {
	public static void main(String[] args) {
		EngenheiroCorrida engenheiro = new EngenheiroCorrida(new EstrategiaAgressiva());
		System.out.println("Agressiva: " + engenheiro.decidir(18, false, "seco"));
		engenheiro.setEstrategia(new EstrategiaConservadora());
		System.out.println("Conservadora: " + engenheiro.decidir(30, true, "seco"));
	}
}
