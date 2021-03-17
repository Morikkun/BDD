package br.com.projeto.entities;

import java.util.Date;

public class NotaAluguel {
	double precoTotal;
	Date dataDevolucao;

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

}
