package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="RahulShettyAcademy.stepDefinitions",monochrome=true
,tags="@ErrorValidation",plugin={"html:Target/cucumber.html"})
public class TestngTestRunner extends AbstractTestNGCucumberTests {

}
