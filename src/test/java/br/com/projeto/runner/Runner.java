package br.com.projeto.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(plugin = "pretty", features = "src/test/resources/features/", snippets = SnippetType.CAMELCASE, monochrome = true, glue = "br.com.projeto.steps")
@RunWith(Cucumber.class)
public class Runner {

}
