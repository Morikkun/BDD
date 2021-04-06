package br.com.projeto.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.projeto.entities.Filme;
import br.com.projeto.entities.NotaAluguel;
import br.com.projeto.exception.NoInventoryException;
import br.com.projeto.services.AluguelService;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LocadoraSteps {
	private Filme filme;
	private NotaAluguel nota = new NotaAluguel();
	private AluguelService aluguel;
	String tipoDeAluguel;
	String erro;

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoqueFilme(arg1);
		int quantidadeEstoque = filme.getEstoqueFilme();
		Assert.assertEquals(arg1, quantidadeEstoque);
	}

	@Dado("^que o preço de aluguel seja R\\$ (\\d+,\\d+)$")
	public void queOPreçoDeAluguelSejaR$(double arg1) throws Throwable {
		filme.setValorLocacao(arg1);
		double valorLocacao = filme.getValorLocacao();
		Assert.assertEquals(arg1, valorLocacao, 0.2);
	}

	@Dado("^que o tipo do aluguel seja (comum|estendido|semanal)$")
	public void queOTipoDoAluguelSejaEstendido(String tipo) throws Throwable {
		nota.setTipoAluguel(tipo);
		tipoDeAluguel = nota.getTipoAluguel();
		Assert.assertEquals(tipo, tipoDeAluguel);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		aluguel = new AluguelService();
		try {
			nota = aluguel.alugar(filme, tipoDeAluguel);
		} catch (NoInventoryException e) {
			e.printStackTrace();
			erro = e.getMessage();
		}

	}

	@Então("^o preço do aluguel será R\\$ (\\d+,\\d+)$")
	public void oPreçoDoAluguelSeráR$(double arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPrecoAluguel(), 0.2);
	}

	@Então("^a data de entrega será em (\\d+) dias$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
		Calendar calEntreEsperada = Calendar.getInstance();
		calEntreEsperada.add(Calendar.DAY_OF_MONTH, arg1);
		Date dataDeRetorno = nota.getDataRetorno();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataDeRetorno);

		Assert.assertEquals(calEntreEsperada.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(calEntreEsperada.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		Assert.assertEquals(calEntreEsperada.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));

	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
		Assert.assertEquals("Não há estoque disponível", erro);
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {

	}
}
