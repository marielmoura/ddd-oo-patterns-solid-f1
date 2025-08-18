// Exemplo: State - estados do carro impactam limites e comportamento

interface EstadoCarro {
	String nome();

	int limiteVelocidadeKmh();
}

class EstadoCorrida implements EstadoCarro {
	public String nome() {
		return "Corrida";
	}

	public int limiteVelocidadeKmh() {
		return 330;
	}
}

class EstadoSafetyCar implements EstadoCarro {
	public String nome() {
		return "Safety Car";
	}

	public int limiteVelocidadeKmh() {
		return 80;
	}
}

class EstadoBox implements EstadoCarro {
	public String nome() {
		return "Box";
	}

	public int limiteVelocidadeKmh() {
		return 60;
	}
}

class CarroF1 {
	private EstadoCarro estado = new EstadoCorrida();

	public void setEstado(EstadoCarro e) {
		this.estado = e;
	}

	public void mostrarStatus() {
		System.out.println("Estado: " + estado.nome() + " | limite: " + estado.limiteVelocidadeKmh() + " km/h");
	}
}

public class ExemploState {
	public static void main(String[] args) {
		CarroF1 carro = new CarroF1();
		carro.mostrarStatus();
		carro.setEstado(new EstadoSafetyCar());
		carro.mostrarStatus();
		carro.setEstado(new EstadoBox());
		carro.mostrarStatus();
		carro.setEstado(new EstadoCorrida());
		carro.mostrarStatus();
	}
}
