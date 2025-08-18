// Exemplo: Decorator para cálculo de tempo de volta com responsabilidades adicionais

interface CalculoTempoVolta {
	double calcularSegundos(ContextoVolta ctx);
}

class ContextoVolta {
	final double base; // tempo base estimado
	final String clima; // "seco" / "chuvoso"
	final boolean safetyCar;

	ContextoVolta(double base, String clima, boolean safetyCar) {
		this.base = base;
		this.clima = clima;
		this.safetyCar = safetyCar;
	}
}

class CalculoBasico implements CalculoTempoVolta {
	public double calcularSegundos(ContextoVolta ctx) {
		return ctx.base;
	}
}

abstract class CalculoDecorator implements CalculoTempoVolta {
	protected final CalculoTempoVolta interno;

	protected CalculoDecorator(CalculoTempoVolta interno) {
		this.interno = interno;
	}
}

class AjusteClimaDecorator extends CalculoDecorator {
	AjusteClimaDecorator(CalculoTempoVolta interno) {
		super(interno);
	}

	public double calcularSegundos(ContextoVolta ctx) {
		double t = interno.calcularSegundos(ctx);
		if (ctx.clima.equalsIgnoreCase("chuvoso"))
			t += 4.0; // chuva aumenta tempo
		return t;
	}
}

class SafetyCarDecorator extends CalculoDecorator {
	SafetyCarDecorator(CalculoTempoVolta interno) {
		super(interno);
	}

	public double calcularSegundos(ContextoVolta ctx) {
		double t = interno.calcularSegundos(ctx);
		if (ctx.safetyCar)
			t += 15.0; // ritmo reduzido
		return t;
	}
}

class TelemetriaLoggingDecorator extends CalculoDecorator {
	TelemetriaLoggingDecorator(CalculoTempoVolta interno) {
		super(interno);
	}

	public double calcularSegundos(ContextoVolta ctx) {
		double t = interno.calcularSegundos(ctx);
		System.out.printf("[telemetria] base=%.3f clima=%s sc=%s tempo=%.3f\n", ctx.base, ctx.clima, ctx.safetyCar, t);
		return t;
	}
}

public class ExemploDecorator {
	public static void main(String[] args) {
		CalculoTempoVolta calculo = new TelemetriaLoggingDecorator(
				new SafetyCarDecorator(
						new AjusteClimaDecorator(
								new CalculoBasico())));
		double t1 = calculo.calcularSegundos(new ContextoVolta(90.500, "seco", false));
		double t2 = calculo.calcularSegundos(new ContextoVolta(90.500, "chuvoso", true));
		System.out.printf("Volta seca: %.3f s\n", t1);
		System.out.printf("Volta chuva + SC: %.3f s\n", t2);
	}
}
