package com.bankapp.Banking.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	

	@Autowired
	private AccountRepo ar;
	
	public Account createAccount(Account a) {
		return ar.save(a);
	}
	
	public Optional<Account> getAccount(long id) {
		return ar.findById(id);
	}
	
	public Account deposit(long id,double amount) {
		Account account=getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
		account.setBalance(account.getBalance()+amount);
		return ar.save(account);
	}
	
	public Account withdraw(long id,double amount) {
		Account account=getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
		if(amount>account.getBalance()) {
			throw new RuntimeException("Insufficient Balance");
		}
		account.setBalance(account.getBalance()-amount);
		return ar.save(account);
	}
	
	
}
