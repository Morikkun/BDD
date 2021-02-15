package runners;

import org.junit.Assert;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

public class Principal {

	int contador = 0;

	@Dado("^um contador que inicia em (\\d+)$")
	public void um_contador_que_inicia_em(int arg1) throws Throwable {
		contador = arg1;

	}

	@Quando("^o incremento em (\\d+)$")
	public void o_incremento_em(int arg1) throws Throwable {
		contador += arg1;

	}

	@Então("^seu resultado final é (\\d+)$")
	public void seu_resultado_final_é(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);

	}
}
