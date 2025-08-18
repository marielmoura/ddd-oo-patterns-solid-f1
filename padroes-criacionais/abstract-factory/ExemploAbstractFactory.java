// Exemplo: Abstract Factory para famílias de componentes por fornecedor
// Nomes em PT-BR seguindo a linguagem do domínio (F1)

interface Motor {
	String fornecedor();

	int potenciaCv();
}

interface CaixaDeMarchas {
	String fornecedor();

	int marchas();
}

// UCE = Unidade de Controle Eletrônico (ECU)
interface UCE {
	String fornecedor();

	String mapa();
}

class MotorMerc implements Motor {
	public String fornecedor() {
		return "Merc";
	}

	public int potenciaCv() {
		return 1010;
	}
}

class CaixaDeMarchasMerc implements CaixaDeMarchas {
	public String fornecedor() {
		return "Merc";
	}

	public int marchas() {
		return 8;
	}
}

class UCEMerc implements UCE {
	public String fornecedor() {
		return "Merc";
	}

	public String mapa() {
		return "mapa-pro-mercedes";
	}
}

class MotorFerrari implements Motor {
	public String fornecedor() {
		return "Ferrari";
	}

	public int potenciaCv() {
		return 1000;
	}
}

class CaixaDeMarchasFerrari implements CaixaDeMarchas {
	public String fornecedor() {
		return "Ferrari";
	}

	public int marchas() {
		return 8;
	}
}

class UCEFerrari implements UCE {
	public String fornecedor() {
		return "Ferrari";
	}

	public String mapa() {
		return "mapa-pro-ferrari";
	}
}

interface FabricaConjuntoPropulsao {
	Motor motor();

	CaixaDeMarchas caixa();

	UCE uce();
}

class FabricaMerc implements FabricaConjuntoPropulsao {
	public Motor motor() {
		return new MotorMerc();
	}

	public CaixaDeMarchas caixa() {
		return new CaixaDeMarchasMerc();
	}

	public UCE uce() {
		return new UCEMerc();
	}
}

class FabricaFerrari implements FabricaConjuntoPropulsao {
	public Motor motor() {
		return new MotorFerrari();
	}

	public CaixaDeMarchas caixa() {
		return new CaixaDeMarchasFerrari();
	}

	public UCE uce() {
		return new UCEFerrari();
	}
}

class CarroMontado {
	final Motor motor;
	final CaixaDeMarchas caixa;
	final UCE uce;

	CarroMontado(FabricaConjuntoPropulsao f) {
		this.motor = f.motor();
		this.caixa = f.caixa();
		this.uce = f.uce();
	}

	public String descricao() {
		return String.format("%s/%s/%s %dcv %d marchas", motor.fornecedor(), caixa.fornecedor(), uce.fornecedor(),
				motor.potenciaCv(), caixa.marchas());
	}
}

public class ExemploAbstractFactory {
	public static void main(String[] args) {
		CarroMontado a = new CarroMontado(new FabricaMerc());
		CarroMontado b = new CarroMontado(new FabricaFerrari());
		System.out.println(a.descricao());
		System.out.println(b.descricao());
	}
}
