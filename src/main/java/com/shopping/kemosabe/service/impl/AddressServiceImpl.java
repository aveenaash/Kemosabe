package com.shopping.kemosabe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.kemosabe.domain.Address;
import com.shopping.kemosabe.repository.AddressRepository;
import com.shopping.kemosabe.service.AddressService;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return (List<Address>) addressRepository.findAll();
	}


	

}
