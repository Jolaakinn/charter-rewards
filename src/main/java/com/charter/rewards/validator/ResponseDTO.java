package com.charter.rewards.validator;


import com.charter.rewards.util.Constants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

//  @JsonSerialize(using = JsonDateSerializer.class)
  private Date timestamp;

  private String message;

  private List<String> errors;

  private Object data;

  public ResponseDTO(Date timestamp, String message, String error) {
    this.timestamp = timestamp;
    this.message = message;
    this.errors = Arrays.asList(error);
  }

  public ResponseDTO(Date timestamp, String message, List<String> error) {
    this.timestamp = timestamp;
    this.message = message;
    this.errors = error;
  }

  public ResponseDTO(Object data) {
    this.timestamp = new Date();
    this.message = Constants.SUCCESS_MESSAGE;
    this.data = data;
  }

  public ResponseDTO(String error) {
    this.timestamp = new Date();
    this.message = Constants.ERROR_MESSAGE;
    this.errors = Arrays.asList(error);
  }
}