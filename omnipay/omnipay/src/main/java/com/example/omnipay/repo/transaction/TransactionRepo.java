package com.example.omnipay.repo.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.omnipay.data.transaction.TransactionData;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionData,Integer> {

}
