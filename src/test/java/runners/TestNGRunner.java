package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				}, 
		monochrome = true,
		glue = { "steps","hooks" },
		features = { "src/test/java/features" }
)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}
