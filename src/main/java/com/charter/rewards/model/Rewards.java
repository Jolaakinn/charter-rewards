package com.charter.rewards.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Rewards {
    private long customerId;
	private long lastMonthRewardPoints;
    private long twoMonthsAgoReward;
    private long threeMonthsAgoReward;
    private long totalRewards;


}
