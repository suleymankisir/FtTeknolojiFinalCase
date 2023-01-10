package FTTeknoloji.Account.api.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import FTTeknoloji.Account.businness.abstracts.CustomerService;
import FTTeknoloji.Account.entities.concretes.Customer;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	
	
	private CustomerService customerService;


	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		
		return this.customerService.add(customer);
		
	}
	

	@GetMapping("/getall")
	public List<Customer> getAll(){
		
		return this.customerService.getall();
	}
	
	@GetMapping("/buy/{from}/{to}/{quantity}/{customerId}")
	public List<Customer> getMoney(@PathVariable int customerId,@PathVariable String from,@PathVariable String to,@PathVariable int quantity) {
		
	 this.customerService.setBuyMoney(customerId,from,to,quantity);
	 return this.customerService.getall();
		
		
	}
	
	@GetMapping("/sell/{from}/{to}/{quantity}/{customerId}")
	public List<Customer> sellMoney(@PathVariable int customerId,@PathVariable String from,@PathVariable String to,@PathVariable int quantity) {
		
	 this.customerService.setSellMoney(customerId, from, to, quantity);
	 return this.customerService.getall();
		
		
	}
	
	
	
}
