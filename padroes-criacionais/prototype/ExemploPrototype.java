// Exemplo: Prototype - clonar setup base e ajustar detalhes

class SetupCarro implements Cloneable {
	int asaDianteira;
	int asaTraseira;
	String mapaMotor;

	SetupCarro(int dianteira, int traseira, String mapa) {
		this.asaDianteira = dianteira;
		this.asaTraseira = traseira;
		this.mapaMotor = mapa;
	}

	public SetupCarro clone() {
		try {
			return (SetupCarro) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
	}

	public String toString() {
		return "asaD " + asaDianteira + ", asaT " + asaTraseira + ", mapa " + mapaMotor;
	}
}

public class ExemploPrototype {
	public static void main(String[] args) {
		SetupCarro base = new SetupCarro(4, 6, "economia");
		SetupCarro quali = base.clone();
		quali.mapaMotor = "ataque";
		quali.asaDianteira = 5;
		System.out.println("Base: " + base);
		System.out.println("Quali: " + quali);
	}
}
