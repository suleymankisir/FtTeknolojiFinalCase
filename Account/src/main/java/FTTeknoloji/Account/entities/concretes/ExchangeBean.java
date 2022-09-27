package FTTeknoloji.Account.entities.concretes;

import lombok.Data;

@Data
public class ExchangeBean {
	
	private int exchangeId;
	
	private String majorCurrency;
	
	private String minorCurrency;
	
	private double sellRate; 
	
	private double buyRate; 
	
	private int port;

}
