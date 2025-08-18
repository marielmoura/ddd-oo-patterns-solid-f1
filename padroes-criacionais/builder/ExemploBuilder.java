
// Exemplo: Builder - montar um plano de corrida passo a passo
import java.util.ArrayList;
import java.util.List;

class PlanoCorrida {
	final String compostoInicial;
	final List<Integer> paradas;
	final String mapaMotor;

	PlanoCorrida(String compostoInicial, List<Integer> paradas, String mapaMotor) {
		this.compostoInicial = compostoInicial;
		this.paradas = paradas;
		this.mapaMotor = mapaMotor;
	}

	public String toString() {
		return "Inicio: " + compostoInicial + ", paradas " + paradas + ", mapa " + mapaMotor;
	}
}

class PlanoCorridaBuilder {
	private String compostoInicial = "médios";
	private final List<Integer> paradas = new ArrayList<>();
	private String mapaMotor = "conservador";

	public PlanoCorridaBuilder compostoInicial(String composto) {
		this.compostoInicial = composto;
		return this;
	}

	public PlanoCorridaBuilder adicionarParadaNaVolta(int volta) {
		this.paradas.add(volta);
		return this;
	}

	public PlanoCorridaBuilder mapaMotor(String mapa) {
		this.mapaMotor = mapa;
		return this;
	}

	public PlanoCorrida build() {
		return new PlanoCorrida(compostoInicial, paradas, mapaMotor);
	}
}

public class ExemploBuilder {
	public static void main(String[] args) {
		PlanoCorrida plano = new PlanoCorridaBuilder()
				.compostoInicial("macios")
				.adicionarParadaNaVolta(18)
				.adicionarParadaNaVolta(38)
				.mapaMotor("ataque")
				.build();
		System.out.println(plano);
	}
}
