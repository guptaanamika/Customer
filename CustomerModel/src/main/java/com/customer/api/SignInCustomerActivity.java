package com.customer.api;

import com.customer.request.SignInCustomerRequest;
import com.customer.response.SignInCustomerResponse;


/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface SignInCustomerActivity {

	public SignInCustomerResponse signInCustomer(SignInCustomerRequest signInCustomerRequest);

}

