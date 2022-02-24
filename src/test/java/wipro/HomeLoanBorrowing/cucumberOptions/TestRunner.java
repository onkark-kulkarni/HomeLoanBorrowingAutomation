package wipro.HomeLoanBorrowing.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/wipro/HomeLoanBorrowing/features",
		glue = "wipro.HomeLoanBorrowing.stepDefinitions",
		stepNotifications = true,		
		monochrome = true,
		plugin = {"json:target/cucumber.json","html:target/Report.html"},
		publish = true

)
public class TestRunner {

	
}
