package com.charter.rewards.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.rewards.entity.CustomerEntity;
import com.charter.rewards.entity.TransactionEntity;
import com.charter.rewards.model.Customer;
import com.charter.rewards.model.Transaction;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.TransactionRepository;
import com.charter.rewards.service.CustomerService;
import com.charter.rewards.util.Util;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransactionRepository transactionRepository;


	public CustomerEntity addCustomer(Customer customer) {
		CustomerEntity entity = new CustomerEntity();
		entity.setCustomerName(customer.getCustomerName());
		return customerRepository.save(entity);
		
	}


	@Override
	public TransactionEntity doTransaction(Transaction transaction) {
		TransactionEntity entity = new TransactionEntity();
		entity.setCustomerId(transaction.getCustomerId());
		entity.setTransactionAmount(transaction.getAmount());
		String transactionId = Util.generateTransactionID("12345");
		entity.setTransactionId(transactionId);
		return transactionRepository.save(entity);
	}


	@Override
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> allCustomers =  (List<CustomerEntity>) customerRepository.findAll();
;		return allCustomers;
	}

}
