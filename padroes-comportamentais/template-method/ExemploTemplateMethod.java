// Exemplo: Template Method para rotina de pit stop com passos fixos e ganchos

abstract class PitStopTemplate {
	// Template
	public final void executar() {
		entrarNoBox();
		pararNoLocal();
		trocarPneus();
		eventuaisAjustes(); // hook
		liberarCarro();
	}

	protected void entrarNoBox() {
		System.out.println("Piloto entra no pit lane");
	}

	protected void pararNoLocal() {
		System.out.println("Carro para no box");
	}

	protected abstract void trocarPneus();

	protected void eventuaisAjustes() {
		/* opcional */ }

	protected void liberarCarro() {
		System.out.println("Lollipop sobe e carro parte");
	}
}

class PitStopSeco extends PitStopTemplate {
	protected void trocarPneus() {
		System.out.println("Troca para slicks médios");
	}
}

class PitStopChuva extends PitStopTemplate {
	protected void trocarPneus() {
		System.out.println("Troca para intermediários");
	}

	protected void eventuaisAjustes() {
		System.out.println("Ajuste extra de asa para chuva");
	}
}

public class ExemploTemplateMethod {
	public static void main(String[] args) {
		PitStopTemplate seco = new PitStopSeco();
		PitStopTemplate chuva = new PitStopChuva();
		seco.executar();
		System.out.println("---");
		chuva.executar();
	}
}
