package FTTeknoloji.Account.entities.concretes;






import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="tl")
	private double tl;
	
	@Column(name="xau")
	private double xau;
	
	@Column(name="usd")
	private double usd;
	
	@Column(name="eur")
	private double eur;
	
	@OneToMany(mappedBy = "customer")
	private List<AccountActivitie> activitie;
	

	
	
	
	
}
