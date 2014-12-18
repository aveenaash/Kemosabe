package com.shopping.kemosabe.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Product;
import com.shopping.kemosabe.domain.ProductsBought;
import com.shopping.kemosabe.domain.Transaction;
import com.shopping.kemosabe.domain.User;
import com.shopping.kemosabe.domain.UserRegistration;
import com.shopping.kemosabe.repository.ProductRepository;
import com.shopping.kemosabe.repository.TransactionRepository;
import com.shopping.kemosabe.repository.UserInfoRepository;
import com.shopping.kemosabe.repository.UserRegistrationRepository;
import com.shopping.kemosabe.service.TransactionService;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactioRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public void addTransaction(Transaction t) {
		transactioRepository.save(t);
	}	

	@Override
	public List<ProductsBought> getTransactionsByBuyers(long buyerId) {
		List<Transaction> transactionList=transactioRepository.getTransactionsByBuyerId(buyerId);
		List<ProductsBought> productsBought=new ArrayList<ProductsBought>();
		for(Transaction t:transactionList)
		{   Product p=productRepository.findOne(t.getProductId());
			User seller=userInfoRepository.findOne(t.getSellerId());
			ProductsBought pb= new ProductsBought();
			pb.setBoughtPrice(t.getBoughtPrice());
			System.out.println("pb.getBoughtPrice()====>"+pb.getBoughtPrice());
			pb.setBoughtDate(t.getBoughtDate());
			pb.setProductName(p.getProductName());
			pb.setProductDescription(p.getProductDescription());
			pb.setProductImage(p.getProductImage());
			pb.setSellerUser(seller);
			System.out.println(p.getProductImage());
			System.out.println("pb.getProductImage()=====>"+pb.getProductImage());			
			productsBought.add(pb);
		}
		return productsBought;
	}

	

}
