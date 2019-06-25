import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Usuario {
	String id;
	int naoLidos;
	ArrayList<Usuario> seguidores;
	ArrayList<Usuario> seguidos;
	ArrayList<Tweet> myTweets;
	ArrayList<Tweet> timeline;

	public Usuario(String id) {
		this.id = id;
		this.naoLidos = 0;
		seguidores = new ArrayList<Usuario>();
		seguidos = new ArrayList<Usuario>();
		myTweets = new ArrayList<Tweet>();
		timeline = new ArrayList<Tweet>();
	}

	public void seguir(Usuario other) {
		for (Usuario user : seguidos)
			if (user.id.equals(other.id))
				return;
		this.seguidos.add(other);
		other.seguidores.add(this);
	}

	public boolean abandonar(Usuario other) {
		for (Usuario user : seguidores)
			if (user.id.equals(other.id)) {
				seguidores.remove(user);
				return true;
			}
		throw new RuntimeException("Erro ao deixar de seguir o usuário: " + other);
	}

	public boolean twittar(Tweet tweet) {
		this.myTweets.add(tweet);
		this.timeline.add(tweet);
		for (Usuario e : seguidores) {
			e.naoLidos++;
			e.timeline.add(tweet);
		}
		return true;
	}

	public void darLike(int idTw) {
		for (Tweet l : timeline)
			if (l.likes.contains(new Usuario(this.id)))
				throw new RuntimeException("fail: Usuário já deu like nesta publicação");

		for (Tweet t : timeline)
			if (t.id == idTw)
				t.likes.add(new Usuario(this.id));

	}

	public Tweet getUnread() {
		if (this.naoLidos != 0) {
			for (int i = 0; i < this.naoLidos; i++) {
				return timeline.get(i);
			}
			this.naoLidos = 0;
		}

		throw new RuntimeException("fail: sem novos tweets");

	}



	public String toString() {
		String saida = id + "\n";
		saida += "Seguidos: [ ";
		for (Usuario user : seguidos)
			saida += user.id + " ";
		saida += "]\nSeguidores: [ ";
		for (Usuario user : seguidores)
			saida += user.id + " ";
		saida += "] \n";
		return saida;
	}
}