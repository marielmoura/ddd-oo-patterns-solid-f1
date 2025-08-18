// Exemplo: Interpreter - avaliar expressão de tempo de volta a partir de terminais do contexto

class Contexto {
	final int baseMs;
	final int degradacaoMs;
	final int chuvaMs;
	final int safetyCarMs;

	Contexto(int baseMs, int degradacaoMs, int chuvaMs, int safetyCarMs) {
		this.baseMs = baseMs;
		this.degradacaoMs = degradacaoMs;
		this.chuvaMs = chuvaMs;
		this.safetyCarMs = safetyCarMs;
	}
}

interface Expressao {
	int interpretar(Contexto ctx);
}

// Terminais
class Constante implements Expressao {
	private final int valor;

	Constante(int v) {
		valor = v;
	}

	public int interpretar(Contexto ctx) {
		return valor;
	}
}

class Base implements Expressao {
	public int interpretar(Contexto ctx) {
		return ctx.baseMs;
	}
}

class Degradacao implements Expressao {
	public int interpretar(Contexto ctx) {
		return ctx.degradacaoMs;
	}
}

class Chuva implements Expressao {
	public int interpretar(Contexto ctx) {
		return ctx.chuvaMs;
	}
}

class SafetyCar implements Expressao {
	public int interpretar(Contexto ctx) {
		return ctx.safetyCarMs;
	}
}

// Não-terminais
class Soma implements Expressao {
	private final Expressao e1, e2;

	Soma(Expressao e1, Expressao e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public int interpretar(Contexto ctx) {
		return e1.interpretar(ctx) + e2.interpretar(ctx);
	}
}

class Subtrai implements Expressao {
	private final Expressao e1, e2;

	Subtrai(Expressao e1, Expressao e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public int interpretar(Contexto ctx) {
		return e1.interpretar(ctx) - e2.interpretar(ctx);
	}
}

public class ExemploInterpreter {
	public static void main(String[] args) {
		// tempo = base + degradação + chuva - safetyCar
		Expressao expr = new Subtrai(
				new Soma(new Soma(new Base(), new Degradacao()), new Chuva()),
				new SafetyCar());
		Contexto seco = new Contexto(92000, 800, 0, 0);
		Contexto chuva = new Contexto(92000, 1200, 2500, 0);
		Contexto safety = new Contexto(92000, 500, 0, 30000);
		System.out.println("Tempo seco: " + expr.interpretar(seco) + " ms");
		System.out.println("Tempo chuva: " + expr.interpretar(chuva) + " ms");
		System.out.println("Tempo com Safety Car: " + expr.interpretar(safety) + " ms");
	}
}
