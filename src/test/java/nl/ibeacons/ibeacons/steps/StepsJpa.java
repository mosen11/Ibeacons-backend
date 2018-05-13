package nl.ibeacons.ibeacons.steps;


import nl.ibeacons.ibeacons.config.H2JpaConfig;
import nl.ibeacons.ibeacons.entity.Customer;
import nl.ibeacons.ibeacons.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories("nl.ibeacons.ibeacons.repository")
@SpringBootTest(classes = H2JpaConfig.class)
//@ContextConfiguration(classes = IbeaconsApplicationTest.class)
@EnableAutoConfiguration
public class StepsJpa {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;


	public Customer whenFindNamethenReturnCustomer() {
		// given
		Customer alex = new Customer();
		alex.setCompoanyURL("http://hello.com");
		alex.setCustomerName("alex");
		Customer cus= (Customer) customerRepository.save(alex);
		customerRepository.flush();
		return cus;

	}

}



