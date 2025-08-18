
// Exemplo: Composite para modelar o carro com componentes e subcomponentes
import java.util.ArrayList;
import java.util.List;

interface Componente {
	String nome();

	double pesoKg();
}

class Parte implements Componente {
	private final String nome;
	private final double peso;

	Parte(String nome, double peso) {
		this.nome = nome;
		this.peso = peso;
	}

	public String nome() {
		return nome;
	}

	public double pesoKg() {
		return peso;
	}
}

class Conjunto implements Componente {
	private final String nome;
	private final List<Componente> filhos = new ArrayList<>();

	Conjunto(String nome) {
		this.nome = nome;
	}

	public Conjunto add(Componente c) {
		filhos.add(c);
		return this;
	}

	public String nome() {
		return nome;
	}

	public double pesoKg() {
		return filhos.stream().mapToDouble(Componente::pesoKg).sum();
	}
}

public class ExemploComposite {
	public static void main(String[] args) {
		Conjunto carro = new Conjunto("Carro F1");
		Conjunto powerUnit = new Conjunto("Power Unit");
		powerUnit.add(new Parte("ICE", 150)).add(new Parte("Turbo", 20)).add(new Parte("MGU-K", 7))
				.add(new Parte("MGU-H", 4));
		Conjunto chassis = new Conjunto("Chassi");
		chassis.add(new Parte("Monocoque", 45)).add(new Parte("Asa Dianteira", 12)).add(new Parte("Asa Traseira", 14));
		carro.add(powerUnit).add(chassis).add(new Parte("Pneus", 50));
		System.out.printf("Peso total: %.1f kg\n", carro.pesoKg());
	}
}
