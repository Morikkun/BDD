package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(plugin = "pretty", features = "src/test/java/")
@RunWith(Cucumber.class)
public class Runner {

}
