package com.customer.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {

	private String customerId;

	private String name;

	private String emailId;

	private String contactNumber;

	private Integer rating;

	private String labelledAddress;

	private Status status;
	
	private Date createdOn;
	
	private Date updatedOn;

}
