
// Exemplo: Memento - salvar e restaurar setup do carro
import java.util.ArrayDeque;
import java.util.Deque;

class SetupCarro {
	int asaD;
	int asaT;
	String mapaMotor;

	SetupCarro(int d, int t, String mapa) {
		this.asaD = d;
		this.asaT = t;
		this.mapaMotor = mapa;
	}

	Snapshot salvar() {
		return new Snapshot(asaD, asaT, mapaMotor);
	}

	void restaurar(Snapshot s) {
		this.asaD = s.asaD;
		this.asaT = s.asaT;
		this.mapaMotor = s.mapaMotor;
	}

	static class Snapshot {
		final int asaD, asaT;
		final String mapaMotor;

		Snapshot(int d, int t, String m) {
			asaD = d;
			asaT = t;
			mapaMotor = m;
		}
	}

	public String toString() {
		return "asaD=" + asaD + ", asaT=" + asaT + ", mapa=" + mapaMotor;
	}
}

class Historico {
	private final Deque<SetupCarro.Snapshot> pilha = new ArrayDeque<>();

	void push(SetupCarro.Snapshot s) {
		pilha.push(s);
	}

	SetupCarro.Snapshot pop() {
		return pilha.pop();
	}
}

public class ExemploMemento {
	public static void main(String[] args) {
		SetupCarro setup = new SetupCarro(4, 6, "economia");
		Historico hist = new Historico();
		hist.push(setup.salvar());
		setup.asaD = 6;
		setup.mapaMotor = "ataque";
		System.out.println("Atual: " + setup);
		setup.restaurar(hist.pop());
		System.out.println("Restaurado: " + setup);
	}
}
