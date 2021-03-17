package br.com.projeto.entities;

public class Filme {
	private int estoque;
	private double precoAluguel;

	public void adicionaEstoque(int i) {
		this.estoque = i;
	}

	public void removeEstoque() {
		this.estoque--;
	}

	public int getEstoque() {
		return estoque;
	}

	public void adicionaPreco(double preco) {
		this.precoAluguel = preco;
	}

	public double getPreco() {
		return precoAluguel;
	}
}
