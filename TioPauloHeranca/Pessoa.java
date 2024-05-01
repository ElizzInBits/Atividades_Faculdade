package TioPauloHeranca;

import java.util.ArrayList;
import java.util.List;

class Pessoa {
	private String nome;
	private int idade;
	private String estadoCivil;

	public Pessoa(String nome, int idade, String estadoCivil) {
		this.nome = nome;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}

class Herdeiro extends Pessoa {
	private String parentesco;
	private double parteHeranca;

	public Herdeiro(String nome, int idade, String estadoCivil, String parentesco, double parteHeranca) {
		super(nome, idade, estadoCivil);
		this.parentesco = parentesco;
		this.parteHeranca = parteHeranca;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public double getParteHeranca() {
		return parteHeranca;
	}

	public void setParteHeranca(double parteHeranca) {
		this.parteHeranca = parteHeranca;
	}

	public void receberHeranca(double valor) {
		this.parteHeranca += valor;
	}
}

class Bem {
	private double valor;
	private String descricao;
	private String estadoConservacao;

	public Bem(double valor, String descricao, String estadoConservacao) {
		this.valor = valor;
		this.descricao = descricao;
		this.estadoConservacao = estadoConservacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstadoConservacao() {
		return estadoConservacao;
	}

	public void setEstadoConservacao(String estadoConservacao) {
		this.estadoConservacao = estadoConservacao;
	}
}

class Testamento {
	private List<Bem> bens;
	private List<Herdeiro> herdeiros;
	private List<Double> porcentagens;

	public Testamento() {
		this.bens = new ArrayList<>();
		this.herdeiros = new ArrayList<>();
		this.porcentagens = new ArrayList<>();
	}

	public void adicionarBem(Bem bem) {
		bens.add(bem);
	}

	public void adicionarHerdeiro(Herdeiro herdeiro, double porcentagem) {
		herdeiros.add(herdeiro);
		porcentagens.add(porcentagem);
	}

	public void calcularHeranca() {
		double totalHeranca = calcularTotalHeranca();

		for (int i = 0; i < herdeiros.size(); i++) {
			Herdeiro herdeiro = herdeiros.get(i);
			double parteHeranca = totalHeranca * porcentagens.get(i);
			herdeiro.receberHeranca(parteHeranca);
		}
	}

	private double calcularTotalHeranca() {
		double total = 0;
		for (Bem bem : bens) {
			total += bem.getValor();
		}
		return total;
	}
}
