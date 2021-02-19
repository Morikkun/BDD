package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(plugin = "pretty", monochrome = true, features = "src/test/java")
@RunWith(Cucumber.class)

public class Runner {

}
