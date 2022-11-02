package com.charter.rewards.service;

import com.charter.rewards.exceptions.DataValidationException;
import com.charter.rewards.exceptions.NotFoundException;
import com.charter.rewards.model.Rewards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;



class RewardServiceTest {
	@Autowired
	RewardsService rewardsService;

	
	@BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }
 

    @BeforeEach
    public static void setup() {
        System.out.println("Instantiating Customer Service before the Test Execution");
    	RewardsService rewardsService;
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("Should Execute After Each Test");
    }

    @Test
    @DisplayName("Should Create Customer")
    public void shouldCreateCustomer() throws DataValidationException, NotFoundException {
    	Rewards request = new Rewards();
    	request.setCustomerId(1);
        assertEquals(request, rewardsService.getRewardsByCustomerId(1l));
    }
    
    @Test
    @DisplayName("Should Not Execute when getRewardsBycustomerId  is null")
    public void shouldThrowRuntimeExceptionWhenCustomerNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
        	rewardsService.getRewardsByCustomerId(null);
        });
    }

    
}