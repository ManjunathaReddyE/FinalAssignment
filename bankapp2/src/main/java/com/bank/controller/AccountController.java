package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.AccountDetail;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/acc")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountService accountService;

	/**
	 * Get all the accounts
	 *
	 * @return ResponseEntity
	 */
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccounts() {
		
		return accountService.getAllAccounts();
		
		}
	

	/**
	 * Get the account by id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDetail> getAccountById(@PathVariable("id") long id) {
		try {
			// check if account exist in database
			Account accObj = getAccountRec(id);
			AccountDetail accDetail=new AccountDetail();

			if (accObj != null) {
				accDetail.setAccountId(accObj.getAccountId());
				accDetail.setAccountType(accObj.getAccountType());
				accDetail.setBalance(accObj.getBalance());
				accDetail.setBank(accObj.getBank());
				//accDetail.setCustomerName(accObj.getCustomer().getCustomerName());
				//accDetail.setAddress(accObj.getCustomer().getAddress());
				//accDetail.setPhone(accObj.getCustomer().getPhone());
				//accDetail.setEmailId(accObj.getCustomer().getEmailId());
				//accObj.setCustomerId(account.getCustomerId());
			}
			return new ResponseEntity<>(accDetail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}

	/**
	 * Create new account for registered customer
	 *
	 * @param Account
	 * @return ResponseEntity
	 */
	@PostMapping("/account") 
	public ResponseEntity<Account> generateAccountForCustomer(@RequestBody Account account) {

		//System.out.println("controller:=="+account.getAccountType());
		return accountService.createAccountForCustomer(account);
		
	}


	/**
	 * Update Account record by using it's id
	 *
	 * @param id
	 * @param Account
	 * @return
	 */
	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account) {

		return accountService.updateAccountDetails(id, account);
	}
	

	@PutMapping("/account/{id}/{bal}")
	public ResponseEntity<Account> updateAccountByBal(@PathVariable("id") long id,@PathVariable double bal, @RequestBody Account account) {

		return accountService.updateAccountByBal(id, account,bal);
	}

	@PutMapping("/updateBal/{bal}/{id}")
	public String updateAccountDetailsByBal(@PathVariable double bal, @PathVariable("id") long id) {

		return accountService.updateAccountDetailsByBal(bal,id);
	}
	/**
	 * Delete Account by Id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable("id") long id) {
		return accountService.deleteAccountById(id);
	}

	/**
	 * Delete all account
	 *
	 * @return ResponseEntity
	 */
	@DeleteMapping("/accounts")
	public ResponseEntity<HttpStatus> deleteAllAccounts() {
		
		return accountService.deleteAllAccounts();

	}

	/**
	 * Method to get the account record by id
	 *
	 * @param id
	 * @return account
	 */
	public Account getAccountRec(long id) {
		
		return accountService.getAccountRecords(id);
	}

}
