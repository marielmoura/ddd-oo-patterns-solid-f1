
// Exemplo: Specification combinável aplicada a CarroF1 (self-contained)
import java.util.Arrays;
import java.util.List;

interface Regra<T> {
	boolean isSatisfeitaPor(T t);

	default Regra<T> e(Regra<T> outra) {
		return (t) -> this.isSatisfeitaPor(t) && outra.isSatisfeitaPor(t);
	}

	default Regra<T> ou(Regra<T> outra) {
		return (t) -> this.isSatisfeitaPor(t) || outra.isSatisfeitaPor(t);
	}
}

class CarroF1 {
	final String equipe;
	final int potencia;
	final String composto;

	CarroF1(String equipe, int potencia, String composto) {
		this.equipe = equipe;
		this.potencia = potencia;
		this.composto = composto;
	}
}

class CarroComPotenciaMinima implements Regra<CarroF1> {
	private final int minima;

	CarroComPotenciaMinima(int minima) {
		this.minima = minima;
	}

	public boolean isSatisfeitaPor(CarroF1 c) {
		return c.potencia >= minima;
	}
}

class CarroComComposto implements Regra<CarroF1> {
	private final String composto;

	CarroComComposto(String composto) {
		this.composto = composto.toLowerCase();
	}

	public boolean isSatisfeitaPor(CarroF1 c) {
		return c.composto.equalsIgnoreCase(composto);
	}
}

public class ExemploEspecificacao {
	public static void main(String[] args) {
		List<CarroF1> grid = Arrays.asList(
				new CarroF1("Equipe A", 1000, "macio"),
				new CarroF1("Equipe B", 980, "medio"),
				new CarroF1("Equipe C", 1010, "macio"));
		Regra<CarroF1> forte = new CarroComPotenciaMinima(1000);
		Regra<CarroF1> comMacio = new CarroComComposto("macio");
		Regra<CarroF1> criterio = forte.e(comMacio);
		grid.stream().filter(criterio::isSatisfeitaPor).forEach(c -> System.out.println(c.equipe));
	}
}
