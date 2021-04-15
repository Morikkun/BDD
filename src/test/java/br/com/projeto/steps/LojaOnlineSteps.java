package br.com.projeto.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LojaOnlineSteps {

	String path = "C:\\Users\\Diego\\eclipse-workspace\\ProjetoAutomacao\\src\\test\\resources\\drivers\\chromedriver.exe";

	protected WebDriver driver;

	@Quando("^eu abrir a aplicação$")
	public void eu_abrir_a_aplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", path);
		String urlDesejada = "https://www.kabum.com.br/";
		driver = new ChromeDriver();
		driver.get(urlDesejada);
		driver.manage().window().maximize();
		String urlAtual = driver.getCurrentUrl();
		Assert.assertTrue(urlDesejada.equals(urlAtual));
	}

	@Quando("^clicar no botão de cadastro$")
	public void clicar_no_botão_de_cadastro() throws Throwable {
		String elementoEsperado = "//*[@id=\"li-login-usuario\"]/a";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = driver.findElement(By.xpath(elementoEsperado));
		element.click();
		String urlEsperada = "https://www.kabum.com.br/cgi-local/site/login/login.cgi";
		wait.until(ExpectedConditions.urlToBe(urlEsperada));
		String urlAtual = driver.getCurrentUrl();
		Assert.assertTrue(urlAtual.equals(urlEsperada));

	}

	@Quando("^inserir \"([^\"]*)\" como email de acesso$")
	public void inserir_como_email_de_acesso(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield"));
		element.sendKeys(arg1);

	}

	@Quando("^digitar \"([^\"]*)\" como senha$")
	public void digitarComoSenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield2"));
		element.sendKeys(arg1);
	}

	@Quando("^digitar \"([^\"]*)\" para confirmar a senha$")
	public void digitarParaConfirmarASenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield3"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" como CPF$")
	public void inserirComoCPF(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("cpfCnpj"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" como CEP$")
	public void inserirComoCEP(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Quando("^clicar em cadastrar$")
	public void clicar_em_cadastrar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Então("^a área do cliente será exibida$")
	public void a_área_do_cliente_será_exibida() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
