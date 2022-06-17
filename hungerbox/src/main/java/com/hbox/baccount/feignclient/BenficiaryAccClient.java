package com.hbox.baccount.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.hbox.model.Baccount;

@FeignClient(value = "BANKAPP-SERVICE", url = "http://localhost:9100/bankapp2/baccount")
public interface BenficiaryAccClient {
	
	@GetMapping("/baccount/{accountNumber}")
	public Baccount getBeneficearyAccountByAccNo(@PathVariable("accountNumber") long accountNumber);
	
	
}
