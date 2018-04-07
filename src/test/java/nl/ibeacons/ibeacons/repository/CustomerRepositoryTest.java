package nl.ibeacons.ibeacons.repository;

import nl.ibeacons.ibeacons.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;

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