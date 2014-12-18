package com.shopping.kemosabe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.kemosabe.domain.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	
	//need to return User who put the product for sell ?
	public List<Transaction> getTransactionsByBuyerId(long buyerId);
}
