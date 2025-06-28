package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features\\RegisterUser.feature", glue = "StepDefinition", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:C:\\IDE-Workspace\\AutomationMavenProject\\Reports\\firstreport.html" })
public class TestRunner {

}
