package FTTeknoloji.Account.businness.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import FTTeknoloji.Account.businness.abstracts.CustomerService;
import FTTeknoloji.Account.dataAccess.abstracts.CustomerDao;
import FTTeknoloji.Account.entities.concretes.Customer;
import FTTeknoloji.Account.entities.concretes.ExchangeBean;



@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	private RestTemplate restTemplate;
	

	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	
	@Override
	public Customer add(Customer customer) {
		
		return this.customerDao.save(customer);
	}
	
	public List<Customer> getall(){
		
		return this.customerDao.findAll();
	}



	@Override
	public void setSellMoney(int customerId, String from, String to, int quantity) {
		
		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("majorCurrency", from);
		uriVariable.put("minorCurrency", to);
		
		ExchangeBean reponse = restTemplate.getForEntity("http://localhost:8001/api/exchange/{majorCurrency}/{minorCurrency}",ExchangeBean.class,uriVariable).getBody();
		
		if (from.equals("USD") && to.equals("TL") && this.customerDao.getByUsd(customerId) >= quantity) {
			double newUsdValue = this.customerDao.getByUsd(customerId)-quantity;
			double newTlValue = this.customerDao.getByTl(customerId)+quantity*reponse.getSellRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setUsd(newUsdValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
		else if (from.equals("EUR") && to.equals("TL") && this.customerDao.getByEur(customerId) >= quantity) {
			double newEurValue = this.customerDao.getByEur(customerId)-quantity;
			double newTlValue = this.customerDao.getByTl(customerId)+quantity*reponse.getSellRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setEur(newEurValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
		else if (from.equals("XAU") && to.equals("TL") && this.customerDao.getByXau(customerId) >= quantity) {
			double newXauValue = this.customerDao.getByXau(customerId)-quantity;
			double newTlValue = this.customerDao.getByTl(customerId)+quantity*reponse.getSellRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setXau(newXauValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
	
}



	@Override
	public void setBuyMoney(int customerId, String from, String to, int quantity) {

		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("majorCurrency", from);
		uriVariable.put("minorCurrency", to);
		
		ExchangeBean reponse = restTemplate.getForEntity("http://localhost:8001/api/exchange/{majorCurrency}/{minorCurrency}",ExchangeBean.class,uriVariable).getBody();
		
		if (from.equals("USD") && to.equals("TL") && this.customerDao.getByTl(customerId) >= quantity*reponse.getBuyRate()) {
			double newUsdValue = this.customerDao.getByUsd(customerId)+quantity;
			double newTlValue = this.customerDao.getByTl(customerId)-quantity*reponse.getBuyRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setUsd(newUsdValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
		else if (from.equals("EUR") && to.equals("TL") && this.customerDao.getByTl(customerId) >= quantity*reponse.getBuyRate()) {
			double newEurValue = this.customerDao.getByEur(customerId)+quantity;
			double newTlValue = this.customerDao.getByTl(customerId)-quantity*reponse.getBuyRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setEur(newEurValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
		else if (from.equals("XAU") && to.equals("TL") && this.customerDao.getByTl(customerId) >= quantity*reponse.getBuyRate()) {
			double newXauValue = this.customerDao.getByXau(customerId)+quantity;
			double newTlValue = this.customerDao.getByTl(customerId)-quantity*reponse.getBuyRate();
			
			this.customerDao.findById(customerId).map(customer -> {
				customer.setXau(newXauValue);
				customer.setTl(newTlValue);
				return this.customerDao.save(customer);
			});
		
		}
		
	}


		
}




		
			

	

