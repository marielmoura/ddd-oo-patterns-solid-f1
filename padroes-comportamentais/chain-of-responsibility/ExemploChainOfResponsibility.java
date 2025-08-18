// Exemplo: Chain of Responsibility - validar pit stop

abstract class Validador {
	private Validador proximo;

	public Validador encadear(Validador v) {
		this.proximo = v;
		return v;
	}

	public final void validar(ContextoPit ctx) {
		if (!fazValidacao(ctx))
			return; // bloqueou
		if (proximo != null)
			proximo.validar(ctx);
	}

	protected abstract boolean fazValidacao(ContextoPit ctx);
}

class ContextoPit {
	boolean pneusProntos;
	boolean mecânicosOK;
	boolean pistaLivre;
}

class VerificaPneus extends Validador {
	protected boolean fazValidacao(ContextoPit c) {
		if (!c.pneusProntos) {
			System.out.println("Falha: pneus não prontos");
			return false;
		}
		return true;
	}
}

class VerificaEquipe extends Validador {
	protected boolean fazValidacao(ContextoPit c) {
		if (!c.mecânicosOK) {
			System.out.println("Falha: equipe não posicionada");
			return false;
		}
		return true;
	}
}

class VerificaPista extends Validador {
	protected boolean fazValidacao(ContextoPit c) {
		if (!c.pistaLivre) {
			System.out.println("Falha: box congestionado");
			return false;
		}
		return true;
	}
}

public class ExemploChainOfResponsibility {
	public static void main(String[] args) {
		Validador v = new VerificaPneus();
		v.encadear(new VerificaEquipe()).encadear(new VerificaPista());
		ContextoPit ok = new ContextoPit();
		ok.pneusProntos = true;
		ok.mecânicosOK = true;
		ok.pistaLivre = true;
		ContextoPit erro = new ContextoPit();
		erro.pneusProntos = true;
		erro.mecânicosOK = false;
		erro.pistaLivre = true;
		System.out.println("Cenário OK:");
		v.validar(ok);
		System.out.println("Aprovado!");
		System.out.println("Cenário ERRO:");
		v.validar(erro);
		System.out.println("Reprovado!");
	}
}
