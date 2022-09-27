package FTTeknoloji.Exchange.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name="exchanges")
public class Exchange {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name= "exchange_id")
	private int exchangeId;
	
	@Column(name= "major_currency")
	private String majorCurrency;
	
	@Column(name= "minor_currency")
	private String minorCurrency;
	
	@Column(name= "sell_rate")
	private double sellRate; 
	
	@Column(name= "buy_rate")
	private double buyRate; 

}
