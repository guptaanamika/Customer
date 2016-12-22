package com.customer.dao;

import com.customer.model.CustomerInfo;

/**
 * @author anamika.gupta created_on : 22-Dec-2016
 **/
public interface CustomerRegistrationDao {

	public void insertCustomer(CustomerInfo customerInfo);

	public CustomerInfo getCustomerInfoByEmailId(String emailId);
}
