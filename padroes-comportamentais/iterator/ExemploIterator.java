
// Exemplo: Iterator - iterar tempos de volta
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Voltas implements Iterable<Integer> {
	private final List<Integer> temposMs;

	Voltas(int... tempos) {
		this.temposMs = new ArrayList<>(tempos.length);
		for (int t : tempos)
			temposMs.add(t);
	}

	public Iterator<Integer> iterator() {
		return temposMs.iterator();
	}
}

public class ExemploIterator {
	public static void main(String[] args) {
		Voltas stint = new Voltas(92000, 91550, 91320, 91410);
		int i = 1;
		int melhor = Integer.MAX_VALUE;
		for (int t : stint) {
			System.out.println("Volta " + i++ + ": " + t + " ms");
			if (t < melhor)
				melhor = t;
		}
		System.out.println("Melhor volta: " + melhor + " ms");
	}
}
