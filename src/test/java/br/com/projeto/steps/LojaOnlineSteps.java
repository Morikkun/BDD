package br.com.projeto.steps;

import java.util.concurrent.TimeUnit;

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

	@Quando("^eu abro a página inicial da aplicação$")
	public void euAbroAPáginaInicialDaAplicação() throws Throwable {
		String url = "https://www.kabum.com.br/";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Quando("^clico no link Login|cadastre-se$")
	public void clicoEmNoLinkLoginCadastreSe() throws Throwable {
		String linkText = "LOGIN | CADASTRE-SE";
		WebElement element = driver.findElement(By.linkText(linkText));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		element.click();
	}

	@Então("^a seção de login deve ser exibida$")
	public void aSeçãoDeLoginDeveSerExibida() throws Throwable {
		String elemento = "//*[@id=\"Table_3\"]/tbody/tr[1]/td/font/b/span/font";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elemento)));
		WebElement element = driver.findElement(By.xpath(elemento));
		String textoEsperado = "Já é cadastrado?";
		String texto = element.getText();
		Assert.assertEquals(textoEsperado, texto);
	}

	@Então("^insiro meu email \"([^\"]*)\"$")
	public void insiroMeu(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield12"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		element.sendKeys(arg1);
	}

	@Então("^insiro minha senha \"([^\"]*)\"$")
	public void insiroMinha(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield15"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		element.sendKeys(arg1);
	}

	@Então("^clico em entrar$")
	public void clicoEmEntrar() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Table_3\"]/tbody/tr[2]/td/p[5]/input"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		element.click();
	}

	@Então("^a mensagem \"([^\"]*)\" deverá aparecer na página$")
	public void aMensagemDeveráAparecerNaPágina(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Então("^quando clicar na área do cliente$")
	public void quandoClicarNaÁreaDoCliente() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Então("^a área do cliente será exibida$")
	public void aÁreaDoClienteSeráExibida() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
