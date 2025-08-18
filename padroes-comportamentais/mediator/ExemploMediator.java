// Exemplo: Mediator - Torre coordena Piloto e Box para uma parada

interface MediadorCorrida {
	void solicitarParada(Piloto piloto, String motivo);

	void setBox(Box box);
}

class TorreCorrida implements MediadorCorrida {
	private Box box;

	public void setBox(Box box) {
		this.box = box;
	}

	public void solicitarParada(Piloto piloto, String motivo) {
		System.out.println("[Torre] Pedido de pit de " + piloto.nome + " (motivo: " + motivo + ")");
		boolean pistaLivre = true; // simplificação
		if (pistaLivre && box.disponivel()) {
			box.prepararPit(piloto);
			piloto.entrarNoBox();
		} else {
			System.out.println("[Torre] Box ocupado, adiar 1 volta");
		}
	}
}

class Piloto {
	final String nome;
	private final MediadorCorrida mediador;

	Piloto(String nome, MediadorCorrida mediador) {
		this.nome = nome;
		this.mediador = mediador;
	}

	void pedirParada(String motivo) {
		mediador.solicitarParada(this, motivo);
	}

	void entrarNoBox() {
		System.out.println("[Piloto] Entrando no box agora!");
	}
}

class Box {
	private boolean ocupado = false;

	boolean disponivel() {
		return !ocupado;
	}

	void prepararPit(Piloto p) {
		ocupado = true;
		System.out.println("[Box] Preparando pit para " + p.nome + " (pneus e ajustes prontos)");
		ocupado = false;
	}
}

public class ExemploMediator {
	public static void main(String[] args) {
		TorreCorrida torre = new TorreCorrida();
		Box box = new Box();
		torre.setBox(box);
		Piloto piloto = new Piloto("Verstappen", torre);
		piloto.pedirParada("perda de desempenho nos pneus");
	}
}
