package com.charter.rewards.service;

import org.springframework.stereotype.Service;

import com.charter.rewards.exceptions.DataValidationException;
import com.charter.rewards.exceptions.NotFoundException;
import com.charter.rewards.model.Rewards;

@Service
public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId) throws DataValidationException,NotFoundException;
}
