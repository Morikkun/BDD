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

public class LojaOnlineSteps {

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

	@Quando("^insiro um e-mail \"([^\"]*)\"$")
	public void insiroUmEMail(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String elementoId = "textfield";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementoId)));
		WebElement element = driver.findElement(By.id("textfield"));
		element.sendKeys(arg1);
	}

	@Quando("^insiro uma senha \"([^\"]*)\"$")
	public void insiroUmaSenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield2"));
		element.sendKeys(arg1);
	}

	@Quando("^confirmo a senha \"([^\"]*)\"$")
	public void confirmoASenha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield3"));
		element.sendKeys(arg1);
	}

	@Quando("^insiro o CPF \"([^\"]*)\"$")
	public void insiroOCPF(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String elementoId = "cpfCnpj";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementoId)));
		WebElement element = driver.findElement(By.id(elementoId));
		element.sendKeys(arg1);
	}

	@Quando("^insiro o CEP \"([^\"]*)\"-\"([^\"]*)\"$")
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

	@Então("^a mensagem de erro é exibida$")
	public void aMensagemDeErroÉExibida() throws Throwable {
		String urlEsperada = "https://www.kabum.com.br/cgi-local/site/login/login.cgi?msg=2";
		String urlAtual = driver.getCurrentUrl();
		Assert.assertEquals(urlEsperada, urlAtual);

	}

}
