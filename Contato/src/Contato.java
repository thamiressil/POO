import java.util.ArrayList;
import java.util.regex.Pattern;

public class Contato {
	String nome;
	ArrayList<Telefone> numero;
	
	public Contato(String nome) {
		super();
		
		if(nome == null)
			this.nome = "vazio";
		else
			this.nome = nome;
		
		numero = new ArrayList<Telefone>();
	}
	
	void inserir_telefone(String label, String numero) {
		this.numero.add(new Telefone(label, numero));
		
	}
	String matches(String numero){
		if(numero.matches("([0-9]*|[(]*|[)]*)*"))
			return numero;

    	throw new RuntimeException("fail: fone invalido");
	}
	
	
	void remover_telefone(String index) {
		numero.remove(index);
	}
	
	int find_index(String num) {
		for(Telefone telefone : numero)
			if(telefone.fone.equals(num))
			return numero.indexOf(telefone);
		return -1;
	}

	public String toString() {
		String saida = "";
		for(Telefone telefone : numero)
			saida += "[" + find_index(telefone.fone) + ":" + telefone.label + ":" + telefone.fone + "]";
		return this.nome + "=>"+ saida;
	}
	
	
}
