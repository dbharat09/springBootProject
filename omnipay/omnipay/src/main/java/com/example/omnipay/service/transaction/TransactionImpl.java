package com.example.omnipay.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.omnipay.data.transaction.TransactionData;
import com.example.omnipay.repo.transaction.TransactionRepo;

@Service
public class TransactionImpl implements Transaction{

	@Autowired
	TransactionRepo transactionRepo;	
	
	/***
	 * @author Bharat kumar
	 */
	@Override
	public String saveTransaction(TransactionData data) throws Exception {
		
		Double actualAmount = Double.parseDouble(data.getActualAmount());
		if(data.getTax() != null)
			actualAmount = actualAmount - Double.parseDouble(data.getTax());
		if(data.getServiceTax() != null)
			actualAmount = actualAmount - Double.parseDouble(data.getServiceTax());
		data.setPayoutAmount(String.valueOf( actualAmount-Double.parseDouble(data.getActualAmount())*.024));
		TransactionData transactionsCreated = transactionRepo.save(data);		
		
		TransactionData transactionUpdated = null;
		String transactionId = null;
		if(transactionsCreated != null && transactionsCreated.getOmniID() > 0) {
			transactionId = data.getClientId() + "/" + data.getRefNo() + "/" + transactionsCreated.getOmniID();
			data.setTransactionID(transactionId);
			data.setTransaction_status("Completed");
			
			transactionUpdated = transactionRepo.save(data);	

			if(transactionUpdated != null && transactionUpdated.getOmniID() > 0)
				return "Transaction completed , this is transactionID " + transactionId;
			else
				throw new Exception();
		}else {
			throw new Exception();
		}
			
		
	}

}
