package com.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.customer.model.CustomerInfo;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaiseComplaintResponse {

	private CustomerInfo customerEntity;
}
