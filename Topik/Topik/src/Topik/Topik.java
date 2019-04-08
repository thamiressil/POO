package Topik;

import java.util.ArrayList;

class Topik {
	ArrayList<Passageiro> cadeiras;
	int capacidade;
	int prioridade;

	public Topik(int capacidade, int prioridade) {
		cadeiras = new ArrayList<Passageiro>(capacidade);
		this.capacidade = capacidade;
		this.prioridade = prioridade;
		for (int i = 0; i < capacidade; i++)
			cadeiras.add(i, null);

	}

	boolean inserir(String id, int idade) {
		Passageiro passageiro = new Passageiro(id, idade);
		int i;
		if (cadeiras.get(capacidade - 1) != null) {
			System.out.println("Todos os lugares estão ocupados!");
			return false;
		} else if (idade >= 60) {
			for (i = 0; i < capacidade; i++) {

				if (cadeiras.get(i) == null && i < prioridade) {
					this.cadeiras.set(i, passageiro);
					System.out.println("Passageiro prioridade inserido!");
					return true;
				} else if (cadeiras.get(i) == null && i > prioridade){
					this.cadeiras.set(i, passageiro);
					System.out.println("Passageiro prioridade inserido em cadeira normal!");
					return true;
				}
			}
			return false;
			
		} else if (idade < 60) {
			for (i = 0; i < capacidade; i++) {
				if (cadeiras.get(i) == null && i >= prioridade) {
					this.cadeiras.set(i, passageiro);
					System.out.println("Passageiro inserido em cadeira normal!");
					return true;
				}
				else if (cadeiras.get(i) == null && i< prioridade) {
					this.cadeiras.set(i, passageiro);
					System.out.println("Passageiro inserido em cadeira prioritária");
					return true;
				}
			}
			return false;
		}
		return false;
	}

	void remover(String id) {
		for (int i = 0; i < this.cadeiras.size(); i += 1) {
			Passageiro Passageiro = this.cadeiras.get(i);
			if ((Passageiro != null) && (Passageiro.id.equals(id))) {
				this.cadeiras.set(i, null);
				return;
			}
		}
		System.out.println("fail: Passageiro nao esta na topik");
	}

	public String toString() {
		String saida = "[ ";
		for (int i = 0; i < capacidade; i++) {
			if (cadeiras.get(i) == null && i < prioridade)
				saida += "@ ";
			else if (cadeiras.get(i) != null)
				saida += cadeiras.get(i) + " ";
			else {
				saida += "= ";
			}
		}
		saida += "]";
		return saida;
	}

}