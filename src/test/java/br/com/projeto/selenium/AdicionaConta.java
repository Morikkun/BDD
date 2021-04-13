package br.com.projeto.selenium;

import org.openqa.selenium.WebDriver;

public class AdicionaConta {
	private void psvm() {
		String path = "..\\C:\\Users\\Diego\\eclipse-workspace\\ProjetoAutomacao\\src\\test\\resources\\drivers";
		System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
		WebDriver driver = new ChromeDriver;
		
		driver.get("https://www.pichau.com.br/");
	}
}
