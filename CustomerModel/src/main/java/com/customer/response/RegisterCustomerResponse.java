package com.customer.response;

import com.customer.model.CustomerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerResponse {

	private CustomerInfo customerInfo;
}
