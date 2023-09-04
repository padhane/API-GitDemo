package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features= {"AllFeatureFile"},
		glue= {"StepDefinition"},
		dryRun=false
)


public class RunnerTest extends AbstractTestNGCucumberTests
{

}
