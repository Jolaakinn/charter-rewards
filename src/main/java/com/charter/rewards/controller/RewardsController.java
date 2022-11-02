package com.charter.rewards.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.rewards.entity.CustomerEntity;
import com.charter.rewards.entity.TransactionEntity;
import com.charter.rewards.exceptions.DataValidationException;
import com.charter.rewards.exceptions.NotFoundException;
import com.charter.rewards.model.Customer;
import com.charter.rewards.model.Rewards;
import com.charter.rewards.model.Transaction;
import com.charter.rewards.service.CustomerService;
import com.charter.rewards.service.RewardsService;
import com.charter.rewards.validator.NumberOnlyConstraint;
import com.charter.rewards.validator.ResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customers")
@Validated
@Api(value = "RewardsController", description="Operations pertaining to add customers, getting rewards and performing transactions", 
produces = MediaType.APPLICATION_JSON_VALUE)
public class RewardsController {

    @Autowired
    RewardsService rewardsService;
    @Autowired
    CustomerService customerService;
    

//    @NotBlank(message = "customerId is required")
//	@NumberOnlyConstraint(message = "customerId can only be numbers")

    @GetMapping(value = "/rewards/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get customers reward by Cutomers Id", response = Rewards.class)
    public ResponseEntity<ResponseDTO> getRewardsByCustomerId(
    		@PathVariable("customerId") 
    		@ApiParam(name =  "customerId", type = "Long", value = "Customers Id")
    		 Long customerId) throws DataValidationException, NotFoundException{
    	log.debug("CustomerId::" + customerId);
        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return ResponseEntity.ok(new ResponseDTO(customerRewards));
    }
    
    @PostMapping(value = "/customer",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add new Customer", response = CustomerEntity.class)
    public ResponseEntity<ResponseDTO> addCustomer(@Valid @RequestBody Customer customerBody) throws DataValidationException, NotFoundException{
        CustomerEntity customer = customerService.addCustomer(customerBody);
        return ResponseEntity.ok(new ResponseDTO(customer));
    }
    
    @PostMapping(value = "/transaction",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Perform transactions", response = TransactionEntity.class)
    public ResponseEntity<ResponseDTO> performTransactions(@Valid @RequestBody Transaction transactionBody) throws DataValidationException, NotFoundException{
    	TransactionEntity transaction = customerService.doTransaction(transactionBody);
        return ResponseEntity.ok(new ResponseDTO(transaction));
    }


}
