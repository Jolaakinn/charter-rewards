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
public class Customer {
	
	@ApiModelProperty(required = true, example = "John")
	@NotBlank(message = "Customer Name is required")
    private String customerName;


}
