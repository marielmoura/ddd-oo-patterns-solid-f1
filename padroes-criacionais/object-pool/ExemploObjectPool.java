
// Exemplo: Object Pool - reuso de objetos caros (clientes de telemetria)
import java.util.ArrayDeque;
import java.util.Deque;

class ClienteTelemetria {
	private final int id;

	ClienteTelemetria(int id) {
		this.id = id;
	}

	public String toString() {
		return "Cliente#" + id;
	}
}

class PoolTelemetria {
	private final Deque<ClienteTelemetria> livres = new ArrayDeque<>();
	private int seq = 1;
	private final int max;

	PoolTelemetria(int max) {
		this.max = max;
	}

	public ClienteTelemetria adquirir() {
		if (!livres.isEmpty())
			return livres.pop();
		if (seq <= max)
			return new ClienteTelemetria(seq++);
		throw new RuntimeException("Sem clientes disponíveis");
	}

	public void devolver(ClienteTelemetria c) {
		livres.push(c);
	}
}

public class ExemploObjectPool {
	public static void main(String[] args) {
		PoolTelemetria pool = new PoolTelemetria(2);
		ClienteTelemetria c1 = pool.adquirir();
		ClienteTelemetria c2 = pool.adquirir();
		System.out.println("Adquiridos: " + c1 + ", " + c2);
		pool.devolver(c1);
		ClienteTelemetria c3 = pool.adquirir();
		System.out.println("Reutilizado: " + c3 + " (mesmo que c1: " + (c3.toString().equals(c1.toString())) + ")");
	}
}
