package FTTeknoloji.Exchange.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import FTTeknoloji.Exchange.entities.concretes.Exchange;

public interface ExchangeDao extends JpaRepository<Exchange, Integer> {

	Exchange findByMajorCurrencyAndMinorCurrency(String from, String to);
		
}
