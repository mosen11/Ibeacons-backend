package nl.ibeacons.ibeacons.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.ca.Cal;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.ibeacons.ibeacons.services.Calculator;
import org.junit.Assert;


public class ClaculatorSteps {

	private Calculator calculator;

	@Before
	public void setUp(){
		calculator = new Calculator();
	}


	@Given( "^I have a calculator$" )
	public void iHaveACalculator() throws Throwable {
		Assert.assertNotNull(calculator);

	}

	@When("^I add (\\d+) and (\\d+)$")
	public void i_add_and(int arg1, int arg2)  {
		calculator.add(arg1,arg2);
	}

	@Then("^the result should be (\\d+)$")
	public void the_result_should_be(int result) throws Throwable {
		Assert.assertEquals(result, calculator.getResult());

	}

}
