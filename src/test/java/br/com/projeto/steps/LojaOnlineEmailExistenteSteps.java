package br.com.projeto.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LojaOnlineEmailExistenteSteps {

	String path = "C:\\Users\\Diego\\eclipse-workspace\\ProjetoAutomacao\\src\\test\\resources\\drivers\\chromedriver.exe";

	protected WebDriver driver;

	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		String url = "https://www.kabum.com.br/";
		driver.get(url);
		driver.manage().window().maximize();
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(url, urlAtual);
	}

	@Quando("^clico no botão LOGIN | CADASTRAR para fazer meu cadastro$")
	public void clicoNoBotãoLOGINCADASTRARParaFazerMeuCadastro() throws Throwable {
		WebElement element = driver.findElement(By.linkText("LOGIN | CADASTRE-SE"));
		element.click();
	}

	@Quando("^cadastro com o e-mail \"([^\"]*)\"$")
	public void insiroUmEMail(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String elementoId = "textfield";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementoId)));
		WebElement element = driver.findElement(By.id("textfield"));
		element.sendKeys(arg1);
	}

	@Quando("^cadastro com a senha \"([^\"]*)\"$")
	public void insiroUmaSenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield2"));
		element.sendKeys(arg1);
	}

	@Quando("^confirmo a senha \"([^\"]*)\"$")
	public void confirmoASenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield3"));
		element.sendKeys(arg1);
	}

	@Quando("^cadastro com o CPF \"([^\"]*)\"$")
	public void insiroOCPF(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String elementoId = "cpfCnpj";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementoId)));
		WebElement element = driver.findElement(By.id(elementoId));
		element.sendKeys(arg1);
	}

	@Quando("^cadsatro com o CEP \"([^\"]*)\"-\"([^\"]*)\"$")
	public void insiroOCEP(String arg1, String arg2) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield4"));
		element.sendKeys(arg1);

		WebElement element2 = driver.findElement(By.id("textfield5"));
		element2.sendKeys(arg2);
	}

	@Quando("^clico em cadastrar$")
	public void clicoEmCadastrar() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Table_3\"]/tbody/tr[2]/td/input[2]"));
		element.click();
		Thread.sleep(3000);
	}

	@Então("^sou notificado de que o e-mail já está em uso$")
	public void aMensagemDeErroÉExibida() throws Throwable {
		String urlEsperada = "https://www.kabum.com.br/cgi-local/site/login/login.cgi?msg=2";
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(urlEsperada, urlAtual);
	}

	@Quando("^entro com o e-mail \"([^\"]*)\"$")
	public void entroComOEMail(String arg1) throws Throwable {
		String idElemento = "textfield12";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idElemento)));
		WebElement element = driver.findElement(By.id(idElemento));
		element.sendKeys(arg1);
	}

	@Quando("^entro com a senha \"([^\"]*)\"$")
	public void entroComASenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield15"));
		element.sendKeys(arg1);
	}

	@Quando("^quando clico em entrar$")
	public void quandoClicoEmEntrar() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Table_3\"]/tbody/tr[2]/td/p[5]/input"));
		element.click();
		Thread.sleep(3000);
	}

	@Então("^sou notificado de que meu e-mail está incorreto$")
	public void souNotificadoDeQueMeuEMailEstáIncorreto() throws Throwable {
		String urlEsperada = "https://www.kabum.com.br/cgi-local/site/login/login.cgi?msg=1";
		String urlRecebida = driver.getCurrentUrl();
		Assert.assertEquals(urlEsperada, urlRecebida);
	}

}