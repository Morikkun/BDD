package br.com.projeto.services;

import java.util.Calendar;

import br.com.projeto.entities.Filme;
import br.com.projeto.entities.NotaAluguel;
import br.com.projeto.exception.NoInventoryException;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, String tipo) throws NoInventoryException {
		NotaAluguel nota = new NotaAluguel();
		String tipoAluguel = nota.getTipoAluguel();
		int estoque = filme.getEstoqueFilme();

		if (estoque <= 0) {
			throw new NoInventoryException("Não há estoque disponível");
		}

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		nota.setDataRetorno(cal.getTime());

		if ("comum".equals(tipoAluguel)) {
			nota.setPrecoAluguel(filme.getValorLocacao());
			nota.setPontuacaoFidelidade(1);
		} else if ("estendido".equals(tipoAluguel)) {
			nota.setPrecoAluguel(filme.getValorLocacao() * 2);
			nota.setPontuacaoFidelidade(2);
		} else if ("semanal".equals(tipoAluguel)) {
			nota.setPrecoAluguel(filme.getValorLocacao() * 3);
			nota.setPontuacaoFidelidade(3);
		}
		return nota;
	}
}
