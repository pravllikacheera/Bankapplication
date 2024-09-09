package com.bankapp.Banking.Application;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
	
	@Autowired
	private AccountService ac;
	
	@PostMapping("/addAccount")
	public Account createAccount(@RequestBody Account a) {
		return ac.createAccount(a);
	}
	
	@GetMapping("/fectchById/{id}")
	public Optional<Account> getAccount(@PathVariable long id) {
		return ac.getAccount(id);
	}
	
	@PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable long id, @RequestBody Map<String,Double> request) {
		double amount=request.get("amount");
		return ac.deposit(id,amount);
	}
	
	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable long id, @RequestBody Map<String,Double> request) {
		double amount=request.get("amount");
		return ac.withdraw(id,amount);
	}
	

}
