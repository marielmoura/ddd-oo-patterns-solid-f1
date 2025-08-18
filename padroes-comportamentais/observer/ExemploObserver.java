
// Exemplo: Observer para eventos de corrida
import java.util.ArrayList;
import java.util.List;

interface OuvinteCorrida {
	void notificar(String evento);
}

class PainelEquipe implements OuvinteCorrida {
	public void notificar(String evento) {
		System.out.println("[Painel] " + evento);
	}
}

class AppTorcedor implements OuvinteCorrida {
	public void notificar(String evento) {
		System.out.println("[App] " + evento);
	}
}

class CorridaEventos {
	private final List<OuvinteCorrida> ouvintes = new ArrayList<>();

	public void registrar(OuvinteCorrida o) {
		ouvintes.add(o);
	}

	public void remover(OuvinteCorrida o) {
		ouvintes.remove(o);
	}

	public void publicar(String evento) {
		ouvintes.forEach(o -> o.notificar(evento));
	}
}

public class ExemploObserver {
	public static void main(String[] args) {
		CorridaEventos bus = new CorridaEventos();
		bus.registrar(new PainelEquipe());
		bus.registrar(new AppTorcedor());
		bus.publicar("Safety Car na pista");
		bus.publicar("Volta mais rápida #81");
	}
}
