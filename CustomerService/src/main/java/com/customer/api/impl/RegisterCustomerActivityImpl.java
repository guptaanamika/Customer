package com.customer.api.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.api.RegisterCustomerActivity;
import com.customer.converter.CustomerExceptionHandler;
import com.customer.dao.PersistenceManager;
import com.customer.model.CustomerInfo;
import com.customer.model.Status;
import com.customer.request.RegisterCustomerRequest;
import com.customer.response.RegisterCustomerResponse;
import com.customer.validator.RequestParamValidator;

/**
 * @author anamika.gupta created_on : 22-Dec-2016
 **/
@Service
public class RegisterCustomerActivityImpl implements RegisterCustomerActivity {

	@Autowired
	private CustomerExceptionHandler exceptionHandler;

	@Autowired
	private PersistenceManager persistenceManager;

	private RequestParamValidator validator = new RequestParamValidator();

	@Override
	public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) {
		RegisterCustomerResponse response = new RegisterCustomerResponse();
		try {
			validator.validate(registerCustomerRequest);

			CustomerInfo customerInfo = persistenceManager.getCustomerInfoByEmailId(registerCustomerRequest
					.getEmailId());
			if (null == customerInfo) {
				customerInfo = buildCustomerInfo(registerCustomerRequest);
				persistenceManager.insertCustomer(customerInfo);
			}
			response.setCustomerInfo(customerInfo);
		} catch (Exception e) {
			exceptionHandler.handleExceptions(e);
		}
		return response;
	}

	private CustomerInfo buildCustomerInfo(RegisterCustomerRequest registerCustomerRequest) {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerId(UUID.randomUUID().toString());
		customerInfo.setContactNumber(registerCustomerRequest.getContactNumber());
		customerInfo.setEmailId(registerCustomerRequest.getEmailId());
		customerInfo.setName(registerCustomerRequest.getName());
		customerInfo.setRating(0);
		customerInfo.setStatus(Status.ACTIVE);
		customerInfo.setCreatedOn(new Date());
		customerInfo.setUpdatedOn(new Date());
		return customerInfo;
	}
}
