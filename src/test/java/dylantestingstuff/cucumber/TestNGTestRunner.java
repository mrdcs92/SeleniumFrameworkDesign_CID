package dylantestingstuff.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/dylantestingstuff/cucumber", 
glue="dylantestingstuff/StepDefinitionImpl", 
monochrome=true, 
plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
