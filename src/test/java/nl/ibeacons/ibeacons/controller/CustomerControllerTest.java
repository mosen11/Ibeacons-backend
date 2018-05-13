package nl.ibeacons.ibeacons.controller;

import nl.ibeacons.ibeacons.entity.Customer;
import nl.ibeacons.ibeacons.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.skyscreamer.jsonassert.JSONAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
@JsonTest
public class CustomerControllerTest {

	@Autowired
	private TestEntityManager entityManager;

	@MockBean
	private CustomerService customerService;

	private MockMvc mockMvc;


	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController(customerService))
				.build();
	}

	@Test
	public void getCustomerData() throws Exception {
		String excpect = "{\"id\": 1, \"customerName\": \"test\", \"compoanyURL\": \"http://whatever.com\"}";
		Customer customer = new Customer();
		customer.setCompoanyURL("http://whatever.com");
		customer.setCustomerName("test");
		entityManager.persist(customer);
		entityManager.flush();
		given(customerService.getCustomerData(customer.getId())).willReturn(Optional.of(customer));
		this.mockMvc.perform(get("/customer/customerData/"+ customer.getId()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		MvcResult result=  this.mockMvc.perform(get("/customer/customerData/"+ customer.getId()).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		assertEquals(excpect, result.getResponse()
				.getContentAsString(), false);

	}

}