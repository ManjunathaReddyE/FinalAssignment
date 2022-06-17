package com.bank.service;
import com.bank.controller.AccountController;
import com.bank.model.Account;
import com.bank.model.Baccount;
import com.bank.model.TxnDetail;
import com.bank.model.TxnHistory;
import com.bank.repository.AccountRepository;
import com.bank.repository.BAccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.repository.TxnHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	BeneficearyService beneficearyService;
	
	 @Autowired 
	 AccountRepository accRepository;
	
	 @Autowired
	 BAccountRepository baccrep;
	
	 @Autowired
	 TxnHistoryRepository txnHistoryRepository;
	/**
	 * Get all the accounts
	 * @return ResponseEntity
	 */
	public ResponseEntity<List<TxnDetail>> getTxnHistory() {
		try {
			return new ResponseEntity<>(transactionRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * Get the account by id
	 * @param id
	 * @return ResponseEntity
	 */
	public ResponseEntity<TxnDetail> getTxnDetailsBytxnId(@PathVariable("txnId") long txnId) {
		try {
			// check if account exist in database
			TxnDetail accObj = getAccountRec(txnId);
			if (accObj != null) {
				return new ResponseEntity<>(accObj, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Create new account for registered customer
	 * @param Account
	 * @return ResponseEntity
	 */
	public ResponseEntity<TxnDetail> saveTxn(@RequestBody TxnDetail txnDetail) {
		TxnDetail newTxn =transactionRepository.save(txnDetail);
		return new ResponseEntity<>(newTxn, HttpStatus.OK); }
	/**
	 * Update Account record by using it's id
	 * @param id
	 * @param Account
	 * @return
	 */
	
	public ResponseEntity<String> updateAccountDetails(@RequestBody TxnDetail txnDetail) {
		Baccount bacc=new Baccount();
	try {
		java.util.Date date = new java.util.Date();
		Account sourcAccount=accountService.getAccountRecords(txnDetail.getAccountId());
		Baccount baccExit=beneficearyService.getBAccountByAccNo(txnDetail.getBaccount().getAccountNumber());
		if(baccExit==null)
		{
		System.out.println("Adding New Beneficiary");
		bacc.setAccountNumber(txnDetail.getBaccount().getAccountNumber());
		bacc.setAccountId(txnDetail.getAccountId());
		bacc.setAccountType(txnDetail.getBaccount().getAccountType());
		bacc.setBalance(txnDetail.getBaccount().getBalance());
		bacc.setBank(txnDetail.getBaccount().getBank());
		ResponseEntity<Baccount>createBenef=beneficearyService.createBAccount(bacc);
		//accRepository.save(sourcAccount);
		}
		else
		{
			System.out.println("updating Beneficiary:");
			Baccount bAccount=new Baccount();
			double existbal=baccExit.getBalance();
			System.out.println("update existing account Bal:");
			baccExit.setBalance(existbal+txnDetail.getBaccount().getBalance());
			beneficearyService.updateBAccount(baccExit.getAccountNumber(), baccExit);
		}
		double samount=sourcAccount.getBalance();
		double bamt=(samount-txnDetail.getBaccount().getBalance());
		sourcAccount.setBalance(bamt);
		ResponseEntity<Account> accupdate=accountService.updateAccountDetails(sourcAccount.getAccountId(), sourcAccount);
	
	}catch(Exception e)
	{
		return ResponseEntity.ok().body("Transaction fail");
	}
		
		return ResponseEntity.ok().body("Success");
	}
	
	public Account getSourceAccountDetail(Long accountId)
	{
		AccountController ac=new AccountController();
		Account sAccount=ac.getAccountRec(accountId);
		return sAccount;
	}
	
	/**
	 * Delete Account by Id
	 * @param id
	 * @return ResponseEntity
	 */
	public ResponseEntity<HttpStatus> deleteTxnById(@PathVariable("txnId") long txnId) {
		try {
			// check if Account exist in database
			TxnDetail txn = getAccountRec(txnId);
			if (txn != null) {
				transactionRepository.deleteById(txnId);
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
	public ResponseEntity<HttpStatus> deleteAllTxns() {
		try {
			transactionRepository.deleteAll();
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
	private TxnDetail getAccountRec(long txnId) {
		Optional<TxnDetail> acccObj = transactionRepository.findById(txnId);
		if (acccObj.isPresent()) {
			return acccObj.get();
		}
		return null;
	}

	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}

	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

}
