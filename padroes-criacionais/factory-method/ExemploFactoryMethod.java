// Exemplo: Factory Method para criação de pneus conforme composto
// Contexto F1: decidir o composto de pneu conforme estratégia/condições

interface Pneu {
	String composto();

	int durabilidadeEmVoltas();
}

class PneuMacio implements Pneu {
	public String composto() {
		return "Macio";
	}

	public int durabilidadeEmVoltas() {
		return 15;
	}
}

class PneuMedio implements Pneu {
	public String composto() {
		return "Médio";
	}

	public int durabilidadeEmVoltas() {
		return 25;
	}
}

class PneuDuro implements Pneu {
	public String composto() {
		return "Duro";
	}

	public int durabilidadeEmVoltas() {
		return 35;
	}
}

// Creator (define o Factory Method)
abstract class PneuFactory {
	public Pneu criarPneu(String composto) {
		validar(composto);
		return instanciar(composto);
	}

	protected void validar(String composto) {
		if (composto == null || composto.isBlank())
			throw new IllegalArgumentException("composto inválido");
	}

	protected abstract Pneu instanciar(String composto);
}

// Concrete Creator
class PirelliFactory extends PneuFactory {
	@Override
	protected Pneu instanciar(String composto) {
		String c = composto.toLowerCase();
		switch (c) {
			case "macio":
				return new PneuMacio();
			case "medio":
			case "médio":
				return new PneuMedio();
			case "duro":
				return new PneuDuro();
			default:
				throw new IllegalArgumentException("composto desconhecido: " + composto);
		}
	}
}

public class ExemploFactoryMethod {
	public static void main(String[] args) {
		PneuFactory factory = new PirelliFactory();
		Pneu st1 = factory.criarPneu("macio");
		Pneu st2 = factory.criarPneu("médio");
		System.out.printf("Stint1: %s (~%d voltas)\n", st1.composto(), st1.durabilidadeEmVoltas());
		System.out.printf("Stint2: %s (~%d voltas)\n", st2.composto(), st2.durabilidadeEmVoltas());
	}
}
