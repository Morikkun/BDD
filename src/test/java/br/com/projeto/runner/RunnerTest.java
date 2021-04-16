package br.com.projeto.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(plugin = { "pretty", "html:target/report-html",
		"json:target/report.json" }, features = "src/test/resources/features/", snippets = SnippetType.CAMELCASE, monochrome = true, glue = "br.com.projeto.steps", tags = "@Conta")
@RunWith(Cucumber.class)
public class RunnerTest {

}
