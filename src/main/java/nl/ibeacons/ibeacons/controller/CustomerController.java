package nl.ibeacons.ibeacons.controller;


import nl.ibeacons.ibeacons.entity.Customer;
import nl.ibeacons.ibeacons.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;
	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customerData/{customerId}" )
	@ResponseBody
	public Customer getCustomerData(@PathVariable Long customerId ) {
		return customerService.getCustomerData(customerId).orElseGet(() -> {
			return new Customer();
		});

	}
}
