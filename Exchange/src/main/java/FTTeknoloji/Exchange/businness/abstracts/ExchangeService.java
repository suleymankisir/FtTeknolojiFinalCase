package FTTeknoloji.Exchange.businness.abstracts;

import java.util.List;

import FTTeknoloji.Exchange.entities.concretes.Exchange;

public interface ExchangeService {

	Exchange add(Exchange exchange);
	
	Exchange getMoney(String from,String to);
	
	List<Exchange> getAll();
	
}
