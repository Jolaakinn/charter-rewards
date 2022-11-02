package com.charter.rewards.model;

import javax.validation.constraints.NotBlank;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Transaction {
	
	@ApiModelProperty(required = true, example = "")
//	@NotBlank(message = "Customer Id is required")
    private long customerId;
	@ApiModelProperty(required = true, example = "100")
//	@NotBlank(message = "amount is required")
	private long amount;


}
