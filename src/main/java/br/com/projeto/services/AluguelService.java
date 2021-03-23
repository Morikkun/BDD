package br.com.projeto.services;

import java.util.Calendar;

import br.com.projeto.entities.Filme;
import br.com.projeto.entities.NotaAluguel;

public class AluguelService {

	public NotaAluguel alugarFilme(Filme filme, String tipo) {
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

		String tipoAluguel = nota.getTipoAluguel();

		if ("estendido".equals(tipoAluguel)) {
			nota.adicionaPreco(filme.getPreco() * 2);
			nota.setPontuacaoFidelidade(2);
		} else if (tipoAluguel == "semanal") {
			nota.adicionaPreco(filme.getPreco() * 8);
			nota.setPontuacaoFidelidade(3);
		} else {
			nota.adicionaPreco(filme.getPreco());
			nota.setPontuacaoFidelidade(1);
		}

		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DAY_OF_MONTH, 1);

		nota.setDataDevolucao(cal.getTime());

		return nota;

	}
}
