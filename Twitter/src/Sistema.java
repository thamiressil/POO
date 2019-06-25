import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Sistema {
	int nextTwId = 0;
	Map<String, Usuario> usuarios;
	Map<String, Tweet> tweets;

	public Sistema() {
		usuarios = new TreeMap<String, Usuario>();
		tweets = new TreeMap<String, Tweet>();
	}

	public void addUsuario(String id) {
		Usuario user = usuarios.get(id);
		if (user == null) {
			usuarios.put(id, new Usuario(id));
		}
	}

	public Usuario getUsuario(String id) {
		Usuario user = usuarios.get(id);
		if (user == null)
			throw new RuntimeException("fail: usuario nao encontrado");
		return user;
	}

	public void twittar(String id, String texto) {
		getUsuario(id);
		Tweet novo = new Tweet(this.nextTwId, id, texto);
		this.nextTwId++;
		usuarios.get(id).twittar(novo);
		tweets.put(id, novo);

	}

	public Tweet getTwitter(int idTweet) {
		Set<Entry<String, Tweet>> set = tweets.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Entry<String, Tweet> entry = (Entry) it.next();
			if (entry.getValue().id == idTweet)
				return tweets.get(entry.getKey());
		}

		throw new RuntimeException("Tweet de id número: " + idTweet + " não encontrado");

	}

	public String toString() {
		String saida = "";
		for (Usuario user : usuarios.values())
			saida += user + "\n";
		return saida;
	}
}
