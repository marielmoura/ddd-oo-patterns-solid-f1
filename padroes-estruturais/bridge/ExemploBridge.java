// Exemplo: Bridge - separar abstração de implementação (render de cockpit)

interface RenderizadorCockpit {
	void desenharVelocimetro(int kmh);

	void desenharRpm(int rpm);
}

class RenderConsole implements RenderizadorCockpit {
	public void desenharVelocimetro(int kmh) {
		System.out.println("[Console] Velocidade: " + kmh + " km/h");
	}

	public void desenharRpm(int rpm) {
		System.out.println("[Console] RPM: " + rpm);
	}
}

class RenderHUD implements RenderizadorCockpit {
	public void desenharVelocimetro(int kmh) {
		System.out.println("[HUD] Velocidade: " + kmh + " km/h");
	}

	public void desenharRpm(int rpm) {
		System.out.println("[HUD] RPM: " + rpm);
	}
}

abstract class Cockpit {
	protected final RenderizadorCockpit render;

	protected Cockpit(RenderizadorCockpit r) {
		this.render = r;
	}

	public abstract void atualizar(int kmh, int rpm);
}

class CockpitCorrida extends Cockpit {
	public CockpitCorrida(RenderizadorCockpit r) {
		super(r);
	}

	public void atualizar(int kmh, int rpm) {
		render.desenharVelocimetro(kmh);
		render.desenharRpm(rpm);
	}
}

public class ExemploBridge {
	public static void main(String[] args) {
		Cockpit c1 = new CockpitCorrida(new RenderConsole());
		Cockpit c2 = new CockpitCorrida(new RenderHUD());
		c1.atualizar(312, 11900);
		c2.atualizar(298, 11650);
	}
}
