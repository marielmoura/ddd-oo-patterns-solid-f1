
// Exemplo: Serviço de Domínio - calcular estratégia de pit stops
// Mantido sem package para compilar isolado
import java.util.Arrays;
import java.util.List;

class CorridaContexto {
	final int voltas;
	final List<Integer> degrPorStint; // degradação por stint em voltas
	final String clima; // "seco" ou "chuva"

	CorridaContexto(int voltas, List<Integer> degrPorStint, String clima) {
		this.voltas = voltas;
		this.degrPorStint = degrPorStint;
		this.clima = clima;
	}
}

class PlanoPitStop {
	final List<Integer> voltasParada;
	final String composto;

	PlanoPitStop(List<Integer> voltasParada, String composto) {
		this.voltasParada = voltasParada;
		this.composto = composto;
	}

	public String toString() {
		return "Paradas: " + voltasParada + ", composto: " + composto;
	}
}

interface ServicoEstrategiaPitStop {
	PlanoPitStop calcular(CorridaContexto contexto);
}

class ServicoEstrategiaPitStopPadrao implements ServicoEstrategiaPitStop {
	public PlanoPitStop calcular(CorridaContexto ctx) {
		// regra simples: se chuva, uma parada no meio; se seco, 1 parada com base na
		// degradação
		if ("chuva".equalsIgnoreCase(ctx.clima)) {
			return new PlanoPitStop(Arrays.asList(ctx.voltas / 2), "intermediario");
		}
		int primeiroStint = Math.min(ctx.voltas - 10,
				ctx.degrPorStint.isEmpty() ? ctx.voltas / 2 : ctx.degrPorStint.get(0));
		int restante = ctx.voltas - primeiroStint;
		String composto = restante > 20 ? "duro" : "medio";
		return new PlanoPitStop(Arrays.asList(primeiroStint), composto);
	}
}

public class ExemploServicoDominio {
	public static void main(String[] args) {
		ServicoEstrategiaPitStop serv = new ServicoEstrategiaPitStopPadrao();
		PlanoPitStop planoSeco = serv.calcular(new CorridaContexto(52, Arrays.asList(22, 30), "seco"));
		PlanoPitStop planoChuva = serv.calcular(new CorridaContexto(44, Arrays.asList(), "chuva"));
		System.out.println(planoSeco);
		System.out.println(planoChuva);
	}
}
