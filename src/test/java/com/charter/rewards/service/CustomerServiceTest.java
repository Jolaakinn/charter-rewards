package com.charter.rewards.service;

import com.charter.rewards.model.Customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



class CustomerServiceTest {
	@Autowired
	CustomerService customerService;

	
	@BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }
 

    @BeforeEach
    public static void setup() {
        System.out.println("Instantiating Customer Service before the Test Execution");
    	CustomerService customerService;
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("Should Execute After Each Test");
    }

    @Test
    @DisplayName("Should Create Customer")
    public void shouldCreateCustomer() {
    	Customer request = new Customer();
    	request.setCustomerName("John");
    	customerService.addCustomer(request);
        assertFalse(customerService.getAllCustomers().isEmpty());
        assertEquals(1, customerService.getAllCustomers().size());
    }
    
    @Test
    @DisplayName("Should Not Create Customer When Customer Name is Null")
    public void shouldThrowRuntimeExceptionWhenCustomerNameIsNull() {
    	Customer request = new Customer();
        Assertions.assertThrows(RuntimeException.class, () -> {
        	request.setCustomerName(null);
        	customerService.addCustomer(request);
        });
    }

    
}