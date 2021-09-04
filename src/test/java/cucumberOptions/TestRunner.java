package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"json:target/jsonReports/cucumber-html-report.json" },
		features = "classpath:FeatureFile",
		glue = "classpath:StepDefinations",
		tags = "@Test"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
