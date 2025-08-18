
// Exemplo: Flyweight - compartilhar objetos imutáveis (modelos de asa)
import java.util.*;

final class ModeloAsa {
	final String tipo;
	final int area;
	final int downforce;

	private ModeloAsa(String tipo, int area, int downforce) {
		this.tipo = tipo;
		this.area = area;
		this.downforce = downforce;
	}

	public String toString() {
		return tipo + "(area=" + area + ", df=" + downforce + ")";
	}

	// Factory interna com cache
	private static final Map<String, ModeloAsa> pool = new HashMap<>();

	public static ModeloAsa obter(String tipo) {
		return pool.computeIfAbsent(tipo,
				t -> new ModeloAsa(t, "alto".equals(t) ? 160 : 140, "alto".equals(t) ? 900 : 700));
	}
}

class CarroComAsa {
	final String piloto;
	final ModeloAsa asa;
	final int ajuste;

	CarroComAsa(String piloto, ModeloAsa asa, int ajuste) {
		this.piloto = piloto;
		this.asa = asa;
		this.ajuste = ajuste;
	}

	public String toString() {
		return piloto + "/" + asa + " ajuste=" + ajuste;
	}
}

public class ExemploFlyweight {
	public static void main(String[] args) {
		ModeloAsa alto1 = ModeloAsa.obter("alto");
		ModeloAsa alto2 = ModeloAsa.obter("alto");
		ModeloAsa baixo = ModeloAsa.obter("baixo");
		System.out.println("Mesmo objeto (alto): " + (alto1 == alto2));
		System.out.println(new CarroComAsa("Leclerc", alto1, 3));
		System.out.println(new CarroComAsa("Sainz", alto2, 2));
		System.out.println(new CarroComAsa("Norris", baixo, 1));
	}
}
