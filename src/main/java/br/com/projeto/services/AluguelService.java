package br.com.projeto.services;

import java.util.Calendar;

import br.com.projeto.entities.Filme;
import br.com.projeto.entities.NotaAluguel;

public class AluguelService {

	public NotaAluguel alugarFilme(Filme filme) {
		try {
			if (filme.getEstoque() <= 0) {
				System.out.println("Sem estoque");
			} else {
				filme.removeEstoque();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		NotaAluguel nota = new NotaAluguel();
		nota.adicionaPreco(filme.getPreco());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		nota.setDataDevolucao(cal.getTime());

		return nota;

	}
}
