package com.customer.api;

import com.customer.request.RegisterCustomerRequest;
import com.customer.response.RegisterCustomerResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface RegisterCustomerActivity {

	public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);
}
