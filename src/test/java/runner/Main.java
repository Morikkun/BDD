package runner;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Main {
	@Dado("^que o ticket (especial )?é A.(\\d{3})$")
	public void que_o_ticket_é_AF(String tipo, int arg1) throws Throwable {
		String especial = tipo;
		int ticket = arg1;
		Assert.assertEquals(tipo, especial);
		Assert.assertEquals(arg1, ticket);
	}

	@Dado("^que o valor da passagem é R\\$ (\\d+),(\\d+)$")
	public void que_o_valor_da_passagem_é_R$(int arg1, int arg2) throws Throwable {
		int reais = arg1;
		int centavos = arg2;
		Assert.assertEquals(arg1, reais);
		Assert.assertEquals(arg2, centavos);

	}

	@Dado("^que o nome do passageiro é \\\"(.{5,20})\\\"$")
	public void que_o_nome_do_passageiro_é(String arg1) throws Throwable {
		String nome = arg1;
		Assert.assertEquals(arg1, nome);
	}

	@Dado("^que o telefone do passageiro é (9{4}|8{4})-(8{4}|9{4})$")
	public void que_o_telefone_do_passageiro_é(int arg1, int arg2) throws Throwable {
		int prefixo = arg1;
		int sufixo = arg2;
		Assert.assertEquals(arg1, prefixo);
		Assert.assertEquals(arg2, sufixo);
	}

	@Quando("^criar os steps$")
	public void criar_os_steps() throws Throwable {
		System.out.println("Eles foram criados");
	}

	@Então("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable {
		System.out.println("O teste funcionou");
	}
}
