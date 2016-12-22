package com.customer.service.model;

import java.util.Date;

import lombok.Data;

import com.customer.exception.CustomerException;

public @Data class ServiceResponse<T> {
	  private T response;
	  private CustomerException  exception;
	  private Date serverTimeStamp;
	  
	  public void setResponse(T response){
		  this.response=response;
		  this.serverTimeStamp=new Date();
	  }

}
