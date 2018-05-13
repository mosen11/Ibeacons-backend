package nl.ibeacons.ibeacons.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.ibeacons.ibeacons.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@Configuration
public class MyStepdefs extends StepsJpa {

	@Autowired
	private TestRestTemplate restTemplate;

	private ResponseEntity<String> response;

	private Customer customer = null;

	@When( "^the customer is in DB$" )
	public void theCustomerIsInDB() throws Throwable {
		customer =  whenFindNamethenReturnCustomer();
	}


	@Then( "^find customer is true$" )
	public void findCustomerIsTrue() throws Throwable {
		response = restTemplate
				.exchange("/customer/customerData//{customerId}", HttpMethod.GET, null, String.class, customer.getId());
	}

	@And( "^the customer id is (\\d+)$" )
	public void theCustomerIdIs(int arg0) throws Throwable {
//		response.getBody().equals()
	}
}
