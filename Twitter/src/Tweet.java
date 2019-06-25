import java.util.ArrayList;

public class Tweet {
	int id = 0;
	String idUsuario;
	String msg;
	ArrayList<Usuario> likes;

	public Tweet(int idTw, String idUsuario, String msg) {
		super();
		this.id = idTw;
		this.idUsuario = idUsuario;
		this.msg = msg;
		likes = new ArrayList<Usuario>();
	}
	
	public void darLike(String id){
		for (Usuario e: likes)
			if(e.id.equals(id))
				throw new RuntimeException("fail: usuario já deu like no tweet");
		likes.add(new Usuario(id));
	}
	
	public String toString() {
		String saida = id + ": " + this.idUsuario + "( " + msg + ") ";
		for (Usuario e : likes)
			saida += "[ " + e.id + " ]";
		return saida;
	}

}
