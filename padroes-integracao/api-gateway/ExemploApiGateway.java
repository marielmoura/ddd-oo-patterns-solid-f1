
// Exemplo: API Gateway - agrega respostas de serviços do domínio
import java.util.LinkedHashMap;
import java.util.Map;

interface ServicoPilotos {
	Map<String, Object> piloto(String nome);
}

interface ServicoCorridas {
	Map<String, Object> proximaCorrida();
}

interface ServicoEquipes {
	Map<String, Object> equipe(String nome);
}

class ServicoPilotosMock implements ServicoPilotos {
	public Map<String, Object> piloto(String nome) {
		Map<String, Object> m = new LinkedHashMap<>();
		m.put("nome", nome);
		m.put("numero", 44);
		m.put("equipe", "Mercedes");
		return m;
	}
}

class ServicoCorridasMock implements ServicoCorridas {
	public Map<String, Object> proximaCorrida() {
		Map<String, Object> m = new LinkedHashMap<>();
		m.put("gp", "Monza");
		m.put("data", "2025-09-07");
		return m;
	}
}

class ServicoEquipesMock implements ServicoEquipes {
	public Map<String, Object> equipe(String nome) {
		Map<String, Object> m = new LinkedHashMap<>();
		m.put("nome", nome);
		m.put("sede", "Brackley");
		return m;
	}
}

class ApiGatewayF1 {
	private final ServicoPilotos pilotos;
	private final ServicoCorridas corridas;
	private final ServicoEquipes equipes;

	ApiGatewayF1(ServicoPilotos p, ServicoCorridas c, ServicoEquipes e) {
		this.pilotos = p;
		this.corridas = c;
		this.equipes = e;
	}

	public Map<String, Object> dashboardPiloto(String nome) {
		Map<String, Object> resp = new LinkedHashMap<>();
		Map<String, Object> piloto = pilotos.piloto(nome);
		resp.put("piloto", piloto);
		resp.put("equipe", equipes.equipe(String.valueOf(piloto.get("equipe"))));
		resp.put("proximaCorrida", corridas.proximaCorrida());
		return resp;
	}
}

public class ExemploApiGateway {
	public static void main(String[] args) {
		ApiGatewayF1 api = new ApiGatewayF1(new ServicoPilotosMock(), new ServicoCorridasMock(),
				new ServicoEquipesMock());
		Map<String, Object> out = api.dashboardPiloto("Hamilton");
		System.out.println(out);
	}
}
