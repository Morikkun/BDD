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

public class StepsIniciais {

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

}