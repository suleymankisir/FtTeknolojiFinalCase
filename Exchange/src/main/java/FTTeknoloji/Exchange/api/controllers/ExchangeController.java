package FTTeknoloji.Exchange.api.controllers;





import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTTeknoloji.Exchange.businness.abstracts.ExchangeService;
import FTTeknoloji.Exchange.entities.concretes.Exchange;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

	private ExchangeService exchangeService;

	public ExchangeController(ExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}
	
	@PostMapping("/add")
	public Exchange add(@RequestBody Exchange exchange) {
		
		return this.exchangeService.add(exchange);
	}
	

	@GetMapping("getall")
	public List<Exchange> getall(){
		
		return this.exchangeService.getAll();
		
	}
	
	@GetMapping("/{from}/{to}")
	public Exchange getMoney(@PathVariable String from,@PathVariable String to) {
		
		return this.exchangeService.getMoney(from, to);
	}
	
	
	
	
}
