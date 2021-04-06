package br.com.projeto.entities;

import java.util.Date;

public class NotaAluguel {
	private double precoAluguel;
	private Date dataRetorno;
	private String tipoAluguel;
	private int pontuacaoFidelidade;

	public double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public String getTipoAluguel() {
		return tipoAluguel;
	}

	public void setTipoAluguel(String tipoAluguel) {
		this.tipoAluguel = tipoAluguel;
	}

	public int getPontuacaoFidelidade() {
		return pontuacaoFidelidade;
	}

	public void setPontuacaoFidelidade(int pontuacaoFidelidade) {
		this.pontuacaoFidelidade = pontuacaoFidelidade;
	}

}
