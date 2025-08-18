
// Exemplo: Command - encapsular comandos de box
import java.util.ArrayDeque;
import java.util.Queue;

interface Comando {
	void executar();
}

class Carro {
	void trocarPneus(String composto) {
		System.out.println("Trocando pneus para " + composto);
	}

	void ajustarAsa(int graus) {
		System.out.println("Ajustando asa em " + graus + " graus");
	}
}

class ComandoTrocarPneus implements Comando {
	private final Carro carro;
	private final String composto;

	ComandoTrocarPneus(Carro carro, String composto) {
		this.carro = carro;
		this.composto = composto;
	}

	public void executar() {
		carro.trocarPneus(composto);
	}
}

class ComandoAjustarAsa implements Comando {
	private final Carro carro;
	private final int graus;

	ComandoAjustarAsa(Carro carro, int graus) {
		this.carro = carro;
		this.graus = graus;
	}

	public void executar() {
		carro.ajustarAsa(graus);
	}
}

class BoxInvoker {
	private final Queue<Comando> fila = new ArrayDeque<>();

	void agendar(Comando c) {
		fila.add(c);
	}

	void processar() {
		while (!fila.isEmpty())
			fila.poll().executar();
	}
}

public class ExemploCommand {
	public static void main(String[] args) {
		Carro carro = new Carro();
		BoxInvoker box = new BoxInvoker();
		box.agendar(new ComandoTrocarPneus(carro, "médios"));
		box.agendar(new ComandoAjustarAsa(carro, 2));
		box.processar();
	}
}
