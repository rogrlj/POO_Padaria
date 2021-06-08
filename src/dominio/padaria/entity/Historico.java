package dominio.padaria.entity;

import java.time.LocalDate;

public class Historico {
	
	private int id;
	private String nome;
	private int quantidadeOperacao;
	private String acao;
	private LocalDate date;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeOperacao() {
		return quantidadeOperacao;
	}

	public void setQuantidadeOperacao(int quantidadeOperacao) {
		this.quantidadeOperacao = quantidadeOperacao;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
