package com.charter.rewards.service;





import java.util.List;

import com.charter.rewards.entity.CustomerEntity;
import com.charter.rewards.entity.TransactionEntity;
import com.charter.rewards.model.Customer;
import com.charter.rewards.model.Transaction;


public interface CustomerService {
	
	public CustomerEntity addCustomer(Customer customer);
	public List<CustomerEntity> getAllCustomers();
	public TransactionEntity doTransaction(Transaction transaction);

}
