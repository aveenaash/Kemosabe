package com.shopping.kemosabe.service;


import java.util.List;

import com.shopping.kemosabe.domain.ProductsBought;
import com.shopping.kemosabe.domain.Transaction;

public interface TransactionService {
	
	public void addTransaction(Transaction t);
	
	public List<ProductsBought> getTransactionsByBuyers(long buyerId);
}
