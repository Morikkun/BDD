package br.com.projeto.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.projeto.transformer.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ProjetoSteps {

	int contador = 0;

	// Contador
	@Dado("^um contador que inicia em (\\d+)$")
	public void umContadorQueIniciaEm(int arg1) throws Throwable {
		contador = arg1;

	}

	@Quando("^o incremento em (\\d+)$")
	public void oIncrementoEm(int arg1) throws Throwable {
		contador += arg1;

	}

	@Então("^seu resultado final é (\\d+)$")
	public void seuResultadoFinalE(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);

	}

	// Entrega

	Date entrega = new Date();
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Dado("^que o prazo de entrega é (.*)$")
	public void que_o_prazo_de_entrega_é(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;

	}

	@Quando("^a entrega atrasar em (\\d+) (\\w+)$")
	public void a_entrega_atrasar_em_dias(int arg1, String tempo) throws Throwable {
		if (tempo.equals("dias")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(entrega);
			cal.add(cal.DAY_OF_MONTH, arg1);
			entrega = cal.getTime();
		} else if (tempo.equals("meses")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(entrega);
			cal.add(cal.MONTH, arg1);
			entrega = cal.getTime();
		}

	}

	@Então("^a entrega será feita em (.*)$")
	public void a_entrega_será_feita_em(@Transform(DateConverter.class) Date data) throws Throwable {

		Assert.assertEquals(data, entrega);
	}

	// Locadora

	int estoqueFilmes = 0;
	int filmeAlugado = 0;
	double precoAluguel = 0;
	String tipoAluguel = "estendido";

	@Dado("^um filme com estoque de (\\d+) unidades$")

	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
		estoqueFilmes = arg1;
	}

	@Dado("^que o tipo do aluguel seja estendido$")
	public void queOTipoDoAluguelSejaEstendido() throws Throwable {
		String tipoCerto = "estendido";
		Assert.assertEquals(tipoCerto, tipoAluguel);
	}

	@Dado("^que o preço de aluguel seja R\\$ (\\d+,\\d+)$")
	public void queOPreçoDeAluguelSejaR$(double arg1) throws Throwable {
		precoAluguel = arg1;
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		if (estoqueFilmes > 0) {
			filmeAlugado++;
			System.out.println("Filme alugado");
		}
	}

	@Então("^o preço do aluguel será R\\$ (\\d+,\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
		double precoCerto = arg1;
		Assert.assertEquals(precoCerto, precoAluguel, 0.2);
	}

	@Então("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
		System.out.println("Entrega para amanhã");
	}

	@Então("^a data de entrega será em (\\d+) dias$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {

	}

	@Então("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
		System.out.println("Aluguel não possível");
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
		int estoqueCerto = arg1;
		if (filmeAlugado > 0) {
			estoqueFilmes--;
			Assert.assertEquals(estoqueCerto, estoqueFilmes);
		} else {
			Assert.assertEquals(estoqueCerto, estoqueFilmes);
		}
	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {

	}

}