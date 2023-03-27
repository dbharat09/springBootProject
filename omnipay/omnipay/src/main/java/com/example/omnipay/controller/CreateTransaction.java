package com.example.omnipay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.omnipay.data.transaction.TransactionData;
import com.example.omnipay.service.transaction.Transaction;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/omniPay")
public class CreateTransaction {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private Transaction transaction;
	
	
	/***
	 * @author Bharat Kuamr
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin
	@ApiOperation(value ="save omni pay transactions", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = {"/save/transaction"},method = { RequestMethod.POST })
	public ResponseEntity<String> createTransaction(@RequestBody TransactionData data) throws Exception{
		
		try {
			String transactionID = transaction.saveTransaction(data);
			return new ResponseEntity<String>(transactionID,HttpStatus.OK);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return new ResponseEntity<String>("error in creating transaction" + e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
