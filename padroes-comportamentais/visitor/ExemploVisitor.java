
// Exemplo: Visitor - calcular downforce total visitando componentes
import java.util.*;

interface ComponenteCarro {
	void aceitar(Visitante v);
}

class AsaDianteira implements ComponenteCarro {
	int df;

	AsaDianteira(int df) {
		this.df = df;
	}

	public void aceitar(Visitante v) {
		v.visitar(this);
	}
}

class AsaTraseira implements ComponenteCarro {
	int df;

	AsaTraseira(int df) {
		this.df = df;
	}

	public void aceitar(Visitante v) {
		v.visitar(this);
	}
}

class Assoalho implements ComponenteCarro {
	int df;

	Assoalho(int df) {
		this.df = df;
	}

	public void aceitar(Visitante v) {
		v.visitar(this);
	}
}

interface Visitante {
	void visitar(AsaDianteira a);

	void visitar(AsaTraseira a);

	void visitar(Assoalho a);
}

class VisitanteDownforce implements Visitante {
	int total = 0;

	public void visitar(AsaDianteira a) {
		total += a.df;
	}

	public void visitar(AsaTraseira a) {
		total += a.df;
	}

	public void visitar(Assoalho a) {
		total += a.df;
	}
}

public class ExemploVisitor {
	public static void main(String[] args) {
		List<ComponenteCarro> lista = Arrays.asList(new AsaDianteira(300), new AsaTraseira(350), new Assoalho(450));
		VisitanteDownforce vis = new VisitanteDownforce();
		for (ComponenteCarro c : lista)
			c.aceitar(vis);
		System.out.println("Downforce total: " + vis.total);
	}
}
