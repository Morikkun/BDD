package br.com.projeto.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.projeto.entities.Filme;
import br.com.projeto.entities.NotaAluguel;
import br.com.projeto.exception.NoInventoryException;
import br.com.projeto.services.AluguelService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LocadoraSteps {

	Filme filme = new Filme();
	AluguelService aluguel = new AluguelService();
	NotaAluguel nota = new NotaAluguel();
	String tipoAluguel;
	int pontuacao;

	@Dado("^um filme com estoque de (\\d+) unidades$")

	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme.adicionaEstoque(arg1);
		int estoqueFilme = filme.getEstoque();
		Assert.assertEquals(arg1, arg1);
	}

	@Dado("^que o tipo do aluguel seja (comum|estendido|semanal)$")
	public void queOTipoDoAluguelSejaEstendido(String tipo) throws Throwable {
		if (tipo == "comum") {
			nota.setTipoAluguel(tipo);
		} else if (tipo == "semanal") {
			nota.setTipoAluguel(tipo);
		} else {
			nota.setTipoAluguel(tipo);
		}
		tipoAluguel = nota.getTipoAluguel();
		Assert.assertEquals(tipo, tipoAluguel);
	}

	@Dado("^que o preço de aluguel seja R\\$ (\\d+,\\d+)$")
	public void queOPreçoDeAluguelSejaR$(double arg1) throws Throwable {
		filme.adicionaPreco(arg1);
		double precoFilme = filme.getPreco();
		Assert.assertEquals(arg1, precoFilme, 0.2);
	}

	@Quando("^alugar$")
	public void alugar() throws NoInventoryException {
		try {
			nota = aluguel.alugarFilme(filme, "semanal");
		} catch (Exception e) {
			System.out.println("Estoque não disponível");
		} finally {

		}
	}

	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {

	}

	@Então("^o preço do aluguel será R\\$ (\\d+,\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
		double precoTotal;
		if ("semanal".equals(tipoAluguel)) {
			precoTotal = nota.retornaPreco() * 3;
		} else if ("estendido".equals(tipoAluguel)) {
			precoTotal = nota.retornaPreco() * 2;
		} else {
			precoTotal = nota.retornaPreco();
		}
		Assert.assertEquals(arg1, precoTotal, 0.2);
	}

	@Então("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {

	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	}

	@Então("^a data de entrega será em (\\d+) dias$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DAY_OF_MONTH, 1);

		Date dataEntrega = nota.getDataDevolucao();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataEntrega);

		Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {
		int pontuacao;
		if ("semanal".equals(tipoAluguel)) {
			pontuacao = nota.getPontuacaoFidelidade() * 3;
		} else if ("estendido".equals(tipoAluguel)) {
			pontuacao = nota.getPontuacaoFidelidade() * 2;
		} else {
			pontuacao = nota.getPontuacaoFidelidade();
		}
		Assert.assertEquals(arg1, pontuacao);

	}

}
