// Exemplo: Null Object para Piloto

interface Piloto {
	String nome();

	int numero();

	boolean ativo();
}

class PilotoReal implements Piloto {
	private final String nome;
	private final int numero;
	private final boolean ativo;

	PilotoReal(String nome, int numero, boolean ativo) {
		this.nome = nome;
		this.numero = numero;
		this.ativo = ativo;
	}

	public String nome() {
		return nome;
	}

	public int numero() {
		return numero;
	}

	public boolean ativo() {
		return ativo;
	}
}

class PilotoIndefinido implements Piloto {
	public String nome() {
		return "Indefinido";
	}

	public int numero() {
		return -1;
	}

	public boolean ativo() {
		return false;
	}
}

class Equipe {
	private final Piloto titular;

	Equipe(Piloto piloto) {
		this.titular = piloto == null ? new PilotoIndefinido() : piloto;
	}

	public String cartaz() {
		return "Piloto: " + titular.nome() + " (#" + titular.numero() + ")";
	}
}

public class ExemploNullObject {
	public static void main(String[] args) {
		Equipe e1 = new Equipe(new PilotoReal("Piloto X", 23, true));
		Equipe e2 = new Equipe(null);
		System.out.println(e1.cartaz());
		System.out.println(e2.cartaz());
	}
}
