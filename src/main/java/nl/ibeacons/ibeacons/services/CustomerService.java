package nl.ibeacons.ibeacons.services;


import nl.ibeacons.ibeacons.entity.Customer;
import nl.ibeacons.ibeacons.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public Customer getCustomerData(final Long customerId) {
		return customerRepository.findOne(customerId);
	}
}
