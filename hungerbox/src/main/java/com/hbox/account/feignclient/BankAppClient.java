package com.hbox.account.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hbox.model.AccountDetail;
import com.hbox.model.ItemsDetail;

@FeignClient(name = "http://BANKAPP-SERVICE/bankapp2/acc/account")
public interface BankAppClient {
	
	
	@GetMapping("/{accountId}")
	public AccountDetail getAccountDetailById(@PathVariable Long accountId); 
	
	@PutMapping("/{id}")
	public String updateAccount(@PathVariable("id") long id, @RequestBody AccountDetail account);	
	
	@PutMapping("/{id}/{bal}")
	public String updateAccountByBal(@PathVariable("id") long id,@PathVariable double bal); 
	
	@PutMapping("/account/{id}/{bal}")
	public String updateAccountByBalandId(@PathVariable double bal, @PathVariable("id") long id);
	
	
	@PutMapping("/updateBal/{bal}/{id}")
	public String updateAccountDetailsByBal(@PathVariable double bal, @PathVariable("id") long id);
	
	@GetMapping("/{itemId}")
	public ItemsDetail getItemDetailsById(@PathVariable int itemId); 
	
	@PutMapping("/account/{id}")
	public ItemsDetail updateAccount(@PathVariable int id); 
	
}
