package hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import resources.Reusable;

public class AppHooks {
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) Reusable.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		
		Reusable.quit();
	}

}
