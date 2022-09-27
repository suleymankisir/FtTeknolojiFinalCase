package FTTeknoloji.Account.businness.abstracts;

import java.util.List;


import FTTeknoloji.Account.entities.concretes.Customer;

public interface CustomerService {

	Customer add(Customer customer);
	
	List<Customer> getall();

	void setBuyMoney(int customerId, String from, String to, int quantity);
	
	void setSellMoney(int customerId, String from, String to, int quantity);
	
	
}
