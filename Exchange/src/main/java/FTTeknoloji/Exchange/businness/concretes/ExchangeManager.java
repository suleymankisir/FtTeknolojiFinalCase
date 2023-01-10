package FTTeknoloji.Exchange.businness.concretes;

import java.util.List;


import org.springframework.stereotype.Service;

import FTTeknoloji.Exchange.businness.abstracts.ExchangeService;
import FTTeknoloji.Exchange.dataAccess.abstracts.ExchangeDao;
import FTTeknoloji.Exchange.entities.concretes.Exchange;

@Service
public class ExchangeManager implements ExchangeService {

	private ExchangeDao exchangeDao;

	public ExchangeManager(ExchangeDao exchangeDao) {
		super();
		this.exchangeDao = exchangeDao;
	}


	@Override
	public Exchange add(Exchange exchange) {

		return this.exchangeDao.save(exchange);
	}





	@Override
	public List<Exchange> getAll() {

		return this.exchangeDao.findAll();
	}


	@Override
	public Exchange getMoney(String from, String to) {
		
		return this.exchangeDao.findByMajorCurrencyAndMinorCurrency(from, to);
	}

}
