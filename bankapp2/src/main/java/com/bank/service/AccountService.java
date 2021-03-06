package com.bank.service;
import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	/**
	 * Get all the accounts
	 * @return ResponseEntity
	 */
	public ResponseEntity<List<Account>> getAllAccounts() {
		try {
			return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Create new account for registered customer
	 * @param Account
	 * @return ResponseEntity
	 */
	public ResponseEntity<Account> createAccountForCustomer(@RequestBody Account account) {

		return new ResponseEntity<>(accountRepository.save(account), HttpStatus.OK); 
	}
	
	/**
	 * Update Account record by using it's id
	 * @param id
	 * @param Account
	 * @return
	 */
	public ResponseEntity<Account> updateAccountDetails(long id, Account account) {

		// check if Account exist in database
		Account accObj = getAccountRecords(id);
		if (accObj != null) {
			accObj.setAccountId(account.getAccountId());
			accObj.setAccountType(account.getAccountType());
			accObj.setBalance(account.getBalance());
			accObj.setBank(account.getBank());
			//accObj.setCustomerId(account.getCustomerId());
			return new ResponseEntity<>(accountRepository.save(accObj), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	public ResponseEntity<Account> updateAccountByBal(long id, Account account,double bal) {

		// check if Account exist in database
		Account accObj = getAccountRecords(id);
		double balsum=account.getBalance()+bal;
		System.out.println("balsum  :"+balsum+" getBalance():"+account.getBalance()+"bal: "+bal);
		if (accObj != null) {
			accObj.setAccountId(account.getAccountId());
			accObj.setAccountType(account.getAccountType());
			accObj.setBalance(balsum);
			accObj.setBank(account.getBank());
			//accObj.setCustomerId(account.getCustomerId());
			return new ResponseEntity<>(accountRepository.save(accObj), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public String updateAccountDetailsByBal(double bal,long id) {

		// check if Account exist in database
		Account accObj = getAccountRecords(id);
		double balsum=accObj.getBalance()+bal;
		accObj.setBalance(balsum);
		System.out.println("balsum  :"+balsum+" getBalance():"+accObj.getBalance()+"bal: "+bal);
		try {
		 accountRepository.save(accObj);
		 return "Update Successfull...";
		}catch(Exception e)
		{
		return "Update Failed...!";
		}
	}
	
	/**
	 * Delete Account by Id
	 * @param id
	 * @return ResponseEntity
	 */
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable("id") long id) {
		try {
			// check if Account exist in database
			Account acc = getAccountRecords(id);
			if (acc != null) {
				accountRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete all account
	 * @return ResponseEntity
	 */
	public ResponseEntity<HttpStatus> deleteAllAccounts() {
		try {
			accountRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get the account record by id
	 * @param id
	 * @return account
	 */
	public Account getAccountRecords(long id) {
		Optional<Account> acccObj = accountRepository.findById(id);
		if (acccObj.isPresent()) {
			//Account acc=acccObj.get();
			System.out.println("==acccObj=="+acccObj.get());
			return acccObj.get();
		}
		return null;
	}
}
