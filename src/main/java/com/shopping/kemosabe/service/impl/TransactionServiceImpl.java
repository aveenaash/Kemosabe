package com.shopping.kemosabe.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Transaction;
import com.shopping.kemosabe.repository.TransactionRepository;
import com.shopping.kemosabe.service.TransactionService;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactioRepository;
	
	@Override
	public void addTransaction(Transaction t) {
		transactioRepository.save(t);
	}

	

}
