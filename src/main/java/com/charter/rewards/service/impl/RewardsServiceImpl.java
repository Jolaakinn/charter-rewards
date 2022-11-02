package com.charter.rewards.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.rewards.service.RewardsService;

import lombok.extern.slf4j.Slf4j;

import com.charter.rewards.model.Rewards;
import com.charter.rewards.entity.CustomerEntity;
import com.charter.rewards.entity.TransactionEntity;
import com.charter.rewards.exceptions.CustomException;
import com.charter.rewards.exceptions.DataValidationException;
import com.charter.rewards.exceptions.NotFoundException;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.TransactionRepository;

@Slf4j
@Service
public class RewardsServiceImpl implements RewardsService {
	private int daysInMonths = 30;
//	2 points for every dollar spent over $100 in each transaction,
	private int overAhundredDollarRewardLimit = 100;
//	1 point for every dollar spent over $50 in each transaction
	private int overAFiftyDollarRewardLimit = 50;

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	CustomerRepository customerRepository;

	public Rewards getRewardsByCustomerId(Long customerId) throws DataValidationException, NotFoundException {

		try {

			if (customerId == null) {
				throw new DataValidationException("Missing customer Id");
			} else {
				CustomerEntity customer = customerRepository.findByCustomerId(customerId);
				if (customer == null) {
					throw new NotFoundException("Invalid customer Id");
				}
			}

			Timestamp timeStampForOneMonth = getMonthsAgo(daysInMonths);
			Timestamp timeStampForTwoMonth = getMonthsAgo(2 * daysInMonths);
			Timestamp timeStampForThreeMonth = getMonthsAgo(3 * daysInMonths);

			List<TransactionEntity> lastMonthTransactions = transactionRepository
					.findAllByCustomerIdAndTransactionDateBetween(customerId, getMonthsAgo(daysInMonths),Timestamp.from(Instant.now()));
			List<TransactionEntity> twoMonthsAgoTransactions = transactionRepository
					.findAllByCustomerIdAndTransactionDateBetween(customerId, timeStampForTwoMonth,timeStampForOneMonth);
			List<TransactionEntity> threeMonthsAgoTransactions = transactionRepository
					.findAllByCustomerIdAndTransactionDateBetween(customerId, timeStampForThreeMonth,timeStampForTwoMonth);

			Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
			Long lastSecondMonthRewardPoints = getRewardsPerMonth(twoMonthsAgoTransactions);
			Long lastThirdMonthRewardPoints = getRewardsPerMonth(threeMonthsAgoTransactions);

			Rewards customerRewards = new Rewards();
			customerRewards.setCustomerId(customerId);
			customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
			customerRewards.setTwoMonthsAgoReward(lastSecondMonthRewardPoints);
			customerRewards.setThreeMonthsAgoReward(lastThirdMonthRewardPoints);
			customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);
			return customerRewards;
		} catch (Exception e) {
			log.error("Soomething went wrong"+e);
		}
		return null;

	}

	private Long getRewardsPerMonth(List<TransactionEntity> transactions) {
		return transactions.stream().map(transaction -> calculatePoints(transaction.getTransactionAmount()))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculatePoints(double amount) {
		if (amount > overAhundredDollarRewardLimit && amount <= overAFiftyDollarRewardLimit) {
			return Math.round(amount - overAhundredDollarRewardLimit);
		} else if (amount > overAFiftyDollarRewardLimit) {
			return Math.round(amount - overAFiftyDollarRewardLimit) * 2
					+ (overAFiftyDollarRewardLimit - overAhundredDollarRewardLimit);
		} else
			return 0l;

	}

	public Timestamp getMonthsAgo(int days) {
		System.out.println("System::::::");
		System.out.println(Timestamp.valueOf(LocalDateTime.now().minusDays(days)));
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

//	public static void main(String[] args) {
//		RewardsServiceImpl r = new RewardsServiceImpl();
//		System.out.println(r.calculatePoints(60.0));
//
//		r.getMonthsAgo(30);
//
//	}

}
