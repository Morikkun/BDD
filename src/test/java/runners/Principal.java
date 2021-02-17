package runners;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Principal {

	int contador = 0;

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
}
