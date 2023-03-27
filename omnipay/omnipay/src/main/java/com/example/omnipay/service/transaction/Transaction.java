package com.example.omnipay.service.transaction;

import org.springframework.stereotype.Service;

import com.example.omnipay.data.transaction.TransactionData;

@Service
public interface Transaction {

	String saveTransaction(TransactionData data) throws Exception;
}
