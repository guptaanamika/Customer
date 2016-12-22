package com.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exception.CustomerException;
import com.customer.manager.CustomerService;
import com.customer.request.RegisterCustomerRequest;
import com.customer.response.RegisterCustomerResponse;
import com.customer.service.model.ServiceResponse;
import com.customer.service.model.ServiceUri;

/**
 * @author anamika.gupta
 **/
@RestController
public class CustomerController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = ServiceUri.REGISTER_CUSTOMER, produces = APPLICATION_JSON, method = RequestMethod.POST)
	public ServiceResponse<RegisterCustomerResponse> registerCustomer(
			@RequestBody RegisterCustomerRequest registerCustomerRequest, HttpServletRequest servletRequest) {
		ServiceResponse<RegisterCustomerResponse> serviceResponse = new ServiceResponse<RegisterCustomerResponse>();
		serviceResponse.setResponse(customerService.registerCustomer(registerCustomerRequest));
		return serviceResponse;
	}

	@ExceptionHandler(CustomerException.class)
	public <T> ServiceResponse<T> handleException(CustomerException exception) {
		ServiceResponse<T> response = new ServiceResponse<T>();
		response.setException(exception);
		return response;
	}

}
