package nl.ibeacons.ibeacons.services;

import nl.ibeacons.ibeacons.config.H2JpaConfig;
import nl.ibeacons.ibeacons.entity.Customer;
import nl.ibeacons.ibeacons.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@EnableAutoConfiguration
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private TestEntityManager entityManager;
	Customer alex = new Customer();


	private CustomerService customerService;


//	public CustomerServiceTest(final Customer alex, final CustomerService customerService) {
//		this.alex = alex;
//		this.customerService = customerService;
//	}

	public CustomerServiceTest() {
	}

	@Before
	public void setUp() {
		customerService = new CustomerService(customerRepository);
		alex.setCustomerName("alex");
		alex.setCompoanyURL("http://hello.com");
		entityManager.persist(alex);
		entityManager.flush();
	}

	@Test
	public void getCustomerData() {
		Optional<Customer> found = customerService.getCustomerData(alex.getId());
		assertSame(found.isPresent(),	true);
	}
}