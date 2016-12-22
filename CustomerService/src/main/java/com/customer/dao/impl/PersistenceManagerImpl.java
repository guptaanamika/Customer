package com.customer.dao.impl;

import lombok.experimental.Delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.dao.CustomerRegistrationDao;
import com.customer.dao.PersistenceManager;

/**
 * @author anamika.gupta created_on : 22-Dec-2016
 **/
@Component
public class PersistenceManagerImpl implements PersistenceManager {

	@Autowired
	@Delegate
	private CustomerRegistrationDao customerRegistrationDao;
}
