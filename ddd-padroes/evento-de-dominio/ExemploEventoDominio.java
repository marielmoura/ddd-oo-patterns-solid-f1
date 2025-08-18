
// Exemplo: Evento de Domínio simples com um despachante in-memory
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface EventoDominio {
	String tipo();
}

class CarroQuebrou implements EventoDominio {
	final String piloto;
	final int volta;
	final String motivo;

	CarroQuebrou(String piloto, int volta, String motivo) {
		this.piloto = piloto;
		this.volta = volta;
		this.motivo = motivo;
	}

	public String tipo() {
		return "CarroQuebrou";
	}
}

interface OuvinteDominio {
	void on(EventoDominio evento);
}

class BarramentoEventos {
	private final Map<String, List<OuvinteDominio>> ouvintes = new HashMap<>();

	public void registrar(String tipo, OuvinteDominio ouvinte) {
		ouvintes.computeIfAbsent(tipo, k -> new ArrayList<>()).add(ouvinte);
	}

	public void publicar(EventoDominio e) {
		List<OuvinteDominio> lista = ouvintes.getOrDefault(e.tipo(), Collections.emptyList());
		for (OuvinteDominio o : lista) {
			o.on(e);
		}
	}
}

class TelemetriaListener implements OuvinteDominio {
	public void on(EventoDominio e) {
		if (e instanceof CarroQuebrou) {
			CarroQuebrou c = (CarroQuebrou) e;
			System.out.println("[Telemetria] Falha detectada: " + c.piloto + " volta " + c.volta + " - " + c.motivo);
		}
	}
}

class EstrategiaListener implements OuvinteDominio {
	public void on(EventoDominio e) {
		if (e instanceof CarroQuebrou) {
			CarroQuebrou c = (CarroQuebrou) e;
			System.out.println("[Estrategia] Avaliar Safety Car e pit: " + c.piloto);
		}
	}
}

public class ExemploEventoDominio {
	public static void main(String[] args) {
		BarramentoEventos bus = new BarramentoEventos();
		bus.registrar("CarroQuebrou", new TelemetriaListener());
		bus.registrar("CarroQuebrou", new EstrategiaListener());

		bus.publicar(new CarroQuebrou("Hamilton", 18, "perda de pressão hidráulica"));
	}
}
