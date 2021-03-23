package br.com.projeto.entities;

import java.util.Date;

public class NotaAluguel {
	double precoTotal;
	Date dataDevolucao;
	String tipoAluguel;
	int pontuacaoFidelidade;

	public void adicionaPreco(double d) {
		this.precoTotal = d;
	}

	public double retornaPreco() {
		return this.precoTotal;
	}

	public void setDataDevolucao(Date data) {
		this.dataDevolucao = data;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setTipoAluguel(String tipo) {
		this.tipoAluguel = tipo;
	}

	public String getTipoAluguel() {
		return this.tipoAluguel;
	}

	public int getPontuacaoFidelidade() {
		return pontuacaoFidelidade;
	}

	public void setPontuacaoFidelidade(int pontuacaoFidelidade) {
		this.pontuacaoFidelidade = pontuacaoFidelidade;
	}

}
