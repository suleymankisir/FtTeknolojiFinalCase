package FTTeknoloji.Account.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "accountActivities")
public class AccountActivitie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountActivitieId;
	
	@Column(name="createdby")
	private LocalDate createdBy;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="activitie")
	private String activitie;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	

	
	
}
