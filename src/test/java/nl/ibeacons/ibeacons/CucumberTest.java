package nl.ibeacons.ibeacons;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class)
@CucumberOptions(monochrome = true,
		 features = { "classpath:cucumber/calculator.feature" } ,
		format = {"pretty", "html:target/cucumber"})
public class CucumberTest {

}
