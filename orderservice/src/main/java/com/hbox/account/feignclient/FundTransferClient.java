package com.hbox.account.feignclient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hbox.model.Baccount;
import com.hbox.model.TxnDetail;

@FeignClient(value = "BANKAPP-SERVICE", url = "http://localhost:9100/bankapp2")
public interface FundTransferClient {

	@PutMapping("/fundtransfer")
	public ResponseEntity<String> fundTransfer(@RequestBody TxnDetail txnDetail); 
	
	
	@GetMapping("/baccount/{accountNumber}")
	public Baccount getBeneficearyAccountByAccNo(@PathVariable("accountNumber") long accountNumber);
	
}
