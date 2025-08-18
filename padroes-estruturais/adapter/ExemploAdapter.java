// Exemplo: Adapter para integrar telemetria externa ao nosso domínio
// Objetivo: adaptar uma fonte externa (JSON plano) para uma interface Telemetria

interface Telemetria {
	double velocidadeKmh();

	int rpm();

	double temperaturaMotorC();
}

// Fonte externa com API diferente (simulada)
class FornecedorExternoTelemetria {
	public String payload() {
		// Simula um JSON simples "vel;rpm;temp"
		return "312.7;15300;111.5";
	}
}

// Adapter converte o payload para nossa interface Telemetria
class TelemetriaAdapter implements Telemetria {
	private final String[] parts;

	TelemetriaAdapter(FornecedorExternoTelemetria externo) {
		this.parts = externo.payload().split(";");
	}

	public double velocidadeKmh() {
		return Double.parseDouble(parts[0]);
	}

	public int rpm() {
		return Integer.parseInt(parts[1]);
	}

	public double temperaturaMotorC() {
		return Double.parseDouble(parts[2]);
	}
}

public class ExemploAdapter {
	public static void main(String[] args) {
		Telemetria t = new TelemetriaAdapter(new FornecedorExternoTelemetria());
		System.out.printf("V=%.1f km/h, RPM=%d, Temp=%.1f C\n", t.velocidadeKmh(), t.rpm(), t.temperaturaMotorC());
	}
}
