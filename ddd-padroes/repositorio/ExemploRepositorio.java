
// Exemplo: Repositório DDD - interface do domínio e implementação em memória
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class PilotoId {
	final String valor;

	PilotoId(String v) {
		this.valor = v;
	}

	public String toString() {
		return valor;
	}
}

class Piloto {
	final PilotoId id;
	final String nome;

	Piloto(PilotoId id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String toString() {
		return id + ":" + nome;
	}
}

interface PilotoRepositorio {
	Optional<Piloto> porId(PilotoId id);

	void salvar(Piloto p);

	List<Piloto> todos();
}

class PilotoRepositorioMemoria implements PilotoRepositorio {
	private final Map<String, Piloto> db = new HashMap<>();

	public Optional<Piloto> porId(PilotoId id) {
		return Optional.ofNullable(db.get(id.valor));
	}

	public void salvar(Piloto p) {
		db.put(p.id.valor, p);
	}

	public List<Piloto> todos() {
		return new ArrayList<>(db.values());
	}
}

public class ExemploRepositorio {
	public static void main(String[] args) {
		PilotoRepositorio repo = new PilotoRepositorioMemoria();
		Piloto p = new Piloto(new PilotoId("44"), "Lewis Hamilton");
		repo.salvar(p);
		System.out.println(repo.porId(new PilotoId("44")).orElse(null));
		System.out.println("Total: " + repo.todos().size());
	}
}
