// Exemplo: Facade para orquestrar operações de corrida

class CronometroService {
	double voltaBase() {
		return 90.500;
	}
}

class ClimaService {
	String climaAtual() {
		return "seco";
	}
}

class SafetyCarService {
	boolean ativo() {
		return false;
	}
}

class CorridaFacade {
	private final CronometroService cron;
	private final ClimaService clima;
	private final SafetyCarService sc;

	CorridaFacade(CronometroService cron, ClimaService clima, SafetyCarService sc) {
		this.cron = cron;
		this.clima = clima;
		this.sc = sc;
	}

	public double estimarTempoProximaVolta() {
		double base = cron.voltaBase();
		if ("chuvoso".equalsIgnoreCase(clima.climaAtual()))
			base += 4.0;
		if (sc.ativo())
			base += 15.0;
		return base;
	}
}

public class ExemploFacade {
	public static void main(String[] args) {
		CorridaFacade f = new CorridaFacade(new CronometroService(), new ClimaService(), new SafetyCarService());
		System.out.printf("Estimativa: %.3f s\n", f.estimarTempoProximaVolta());
	}
}
