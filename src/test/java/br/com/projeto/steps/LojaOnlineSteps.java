package br.com.projeto.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@Quando("^inserir \"([^\"]*)\"-\"([^\"]*)\" como CEP$")
	public void inserirComoCEP(String arg1, String arg2) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield4"));
		element.sendKeys(arg1);
		WebElement element2 = driver.findElement(By.id("textfield5"));
		element2.sendKeys(arg2);
	}

	@Quando("^clicar em cadastrar$")
	public void clicar_em_cadastrar() throws Throwable {
		WebElement element = driver.findElement(By.name("cadastrar"));
		element.click();
	}

	@Quando("^inserir \"([^\"]*)\" como primeiro nome$")
	public void inserirComoPrimeiroNome(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("textfield9"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" como segundo nome$")
	public void inserirComoSegundoNome(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("textfield10"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir o RG \"([^\"]*)\"$")
	public void inserirORG(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.name("rg_ie"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" como data de nascimento$")
	public void inserirComoDataDeNascimento(String arg1, String arg2, String arg3) throws Throwable {
		WebElement element = driver.findElement(By.cssSelector("#select4"));
		Select select = new Select(element);
		select.selectByVisibleText(arg1);

		WebElement element2 = driver.findElement(By.cssSelector("#select5"));
		Select select2 = new Select(element2);
		select2.selectByVisibleText(arg2);

		WebElement element3 = driver.findElement(By.cssSelector("#select6"));
		Select select3 = new Select(element3);
		select3.selectByVisibleText(arg3);
	}

	@Quando("^inserir \"([^\"]*)\" \"([^\"]*)\" como telefone fixo$")
	public void inserirComoTelefoneFixo(String arg1, String arg2) throws Throwable {
		WebElement element = driver.findElement(By.name("telefone_ddd"));
		element.sendKeys(arg1);

		WebElement element2 = driver.findElement(By.name("telefone"));
		element2.sendKeys(arg2);
	}

	@Quando("^inserir \"([^\"]*)\" \"([^\"]*)\" como telefone celular$")
	public void inserirComoTelefoneCelular(String arg1, String arg2) throws Throwable {
		WebElement element = driver.findElement(By.name("celular_ddd"));
		element.sendKeys(arg1);

		WebElement element2 = driver.findElement(By.name("celular"));
		element2.sendKeys(arg2);
	}

	@Quando("^inserir \"([^\"]*)\" como número da residência$")
	public void inserirComoNúmeroDaResidência(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.name("endereco_numero"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" como complemento$")
	public void inserirComoComplemento(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.name("endereco_complemento"));
		element.sendKeys(arg1);
	}

	@Quando("^inserir \"([^\"]*)\" como ponto de referência$")
	public void inserirComoPontoDeReferência(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.name("endereco_referencia"));
		element.sendKeys(arg1);
	}

	@Quando("^concordar em receber newsletter$")
	public void concordarEmReceberNewsletter() throws Throwable {
		WebElement element = driver.findElement(By.name("newsletter"));
		Select select = new Select(element);
		select.selectByVisibleText("Sim");
	}

	@Quando("^indicar que conheceu a loja através do \"([^\"]*)\"$")
	public void indicarQueConheceuALojaAtravésDo(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.name("origem"));
		Select select = new Select(element);
		select.selectByVisibleText(arg1);
	}

	@Quando("^concordar com os termos de uso$")
	public void concordarComOsTermosDeUso() throws Throwable {
		WebElement element = driver.findElement(By.name("aceite"));
		element.click();
	}

	@Então("^clicar em concluir$")
	public void clicarEmConcluir() throws Throwable {
		WebElement element = driver.findElement(By.name("cadastrar"));
		element.click();
		driver.manage().timeouts().implicitlyWait(3, null);
	}

}
