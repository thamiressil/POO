package agiota;

import java.util.ArrayList;

class Sistema {
	float saldo;
	ArrayList<Cliente> clientes;
	ArrayList<Transacao> transacoes;
	int nextTrId;

	public Sistema(float saldo) {
		this.saldo = saldo;
		this.clientes = new ArrayList<Cliente>();
		this.transacoes = new ArrayList<Transacao>();
		this.nextTrId = 0;
	}

	void cadastrar(Cliente cliente) {
		try {
			this.findCliente(cliente.id);
			throw new RuntimeException("Cliente ja exite");
		} catch (RuntimeException re) {
			clientes.add(cliente);
		}
	}
	Cliente findClient(String nome) {
		for(Cliente cli : clientes) {
			if(cli.fullname.equals(nome)) {
				return cli;
			}
		}
		throw new RuntimeException("fail: Cliente não existe");
		
	}

	Cliente findCliente(String id) {
		for (Cliente cli : clientes) {
			if (cli.id.equals(id))
				return cli;
		}
		throw new RuntimeException("fail: cliente nao existe");
	}

	void addTransacao(float value, String clienteId) {
		this.transacoes.add(new Transacao(nextTrId, value, clienteId));
		nextTrId += 1;
	}

	void emprestar(String id, float saldo) {
		Cliente cli = findCliente(id);
		addTransacao(-saldo, id);
		this.saldo -= saldo;
		cli.saldo += saldo;
	}

	void receber(String nome, float saldo) {
		Cliente cliente = null;
		for (Cliente cli : clientes) {
			if (cli.fullname.equals(nome)) {
				cliente = cli;
			}
		}
		if (cliente.saldo < saldo) {
			System.out.println("fail: pagamento maior que divida");
			return;
		}
		addTransacao(saldo, cliente.id);
		cliente.saldo -= saldo;
		this.saldo += saldo;
	}

	ArrayList<Transacao> getHistorico() {
		return transacoes;
	}

	void showClient(String nome) {
		Cliente cliente = findClient(nome);
		for (Cliente cli : clientes) {
			if(cli.equals(cliente)) {
				clientes.remove(cli);
			}
		}

		for (Transacao tran : transacoes) {
			if (tran.clientId.equals(cliente.id)) {
				System.out.println(tran);
			}
		}
		System.out.println(cliente.saldo);

	}

	void matar(String nome) {
		Cliente cliente = findClient(nome);
		for (Transacao tran : transacoes) {
			if (tran.clientId.equals(cliente.id)) {
				transacoes.remove(tran);
			}
		}
		
		for (Cliente cli : clientes) {
			if (cli.equals(cliente)) {
				clientes.remove(cli);
			}
		}
		
	}

	@Override
	public String toString() {
		String saida = "";
		for (Cliente cliente : clientes)
			saida += cliente + "\n";
		saida += "saldo:" + this.saldo;
		return saida;
	}
}