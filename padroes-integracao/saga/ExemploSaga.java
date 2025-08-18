// Exemplo: Saga - orquestração simples com compensações

class PedidoTrocaPneu {
	boolean reservadoNoBox;
	boolean pneusSeparados;
	boolean cobrado;
}

interface EtapaSaga {
	boolean executar(PedidoTrocaPneu p);

	void compensar(PedidoTrocaPneu p);
}

class ReservarBox implements EtapaSaga {
	public boolean executar(PedidoTrocaPneu p) {
		System.out.println("Reservando box...");
		p.reservadoNoBox = true;
		return true;
	}

	public void compensar(PedidoTrocaPneu p) {
		if (p.reservadoNoBox) {
			System.out.println("Liberando box (compensação)...");
			p.reservadoNoBox = false;
		}
	}
}

class SepararPneus implements EtapaSaga {
	public boolean executar(PedidoTrocaPneu p) {
		System.out.println("Separando pneus...");
		p.pneusSeparados = true;
		return true;
	}

	public void compensar(PedidoTrocaPneu p) {
		if (p.pneusSeparados) {
			System.out.println("Devolvendo pneus (compensação)...");
			p.pneusSeparados = false;
		}
	}
}

class CobrarPedido implements EtapaSaga {
	public boolean executar(PedidoTrocaPneu p) {
		System.out.println("Cobrando pedido...");
		p.cobrado = true;
		return false;
		/* força falha */ }

	public void compensar(PedidoTrocaPneu p) {
		if (p.cobrado) {
			System.out.println("Estornando cobrança (compensação)...");
			p.cobrado = false;
		}
	}
}

class OrquestradorSaga {
	private final EtapaSaga[] etapas;

	OrquestradorSaga(EtapaSaga... etapas) {
		this.etapas = etapas;
	}

	public void executar(PedidoTrocaPneu p) {
		int idx = 0;
		try {
			for (; idx < etapas.length; idx++) {
				if (!etapas[idx].executar(p))
					throw new RuntimeException("Falha na etapa " + idx);
			}
			System.out.println("Saga concluída com sucesso");
		} catch (RuntimeException ex) {
			System.out.println("Erro: " + ex.getMessage() + ". Iniciando compensações...");
			for (int i = idx - 1; i >= 0; i--)
				etapas[i].compensar(p);
		}
	}
}

public class ExemploSaga {
	public static void main(String[] args) {
		OrquestradorSaga saga = new OrquestradorSaga(new ReservarBox(), new SepararPneus(), new CobrarPedido());
		saga.executar(new PedidoTrocaPneu());
	}
}
