package FTTeknoloji.Account.dataAccess.abstracts;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import FTTeknoloji.Account.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("From Customer where customerId=customerId")
	Customer getByCustomer(int customerId);

	@Query("select usd from Customer where customerId=:customerId")
	double getByUsd(int customerId);

	@Query("select tl from Customer where customerId=:customerId")
	double getByTl(int customerId);
	
	@Query("select eur from Customer where customerId=:customerId")
	double getByEur(int customerId);
	
	@Query("select xau from Customer where customerId=:customerId")
	double getByXau(int customerId);
	
	
	

	
}
