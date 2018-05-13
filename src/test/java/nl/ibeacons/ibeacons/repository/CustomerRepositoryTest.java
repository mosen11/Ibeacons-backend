package nl.ibeacons.ibeacons.repository;

import nl.ibeacons.ibeacons.config.H2JpaConfig;
import nl.ibeacons.ibeacons.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@EnableAutoConfiguration
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerRepositoryTest() {
	}

	@Test
	public void whenFindNamethenReturnCustomer() {
		// given
		Customer alex = new Customer();
		alex.setCompoanyURL("http://hello.com");
		alex.setCustomerName("alex");
		entityManager.persist(alex);
		entityManager.flush();

		Customer found = customerRepository.findByCustomerName(alex.getCustomerName());
		assertSame(found.getCustomerName(),alex.getCustomerName());
	}

}