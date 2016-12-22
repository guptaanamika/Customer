package com.customer.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.dao.CustomerRegistrationDao;
import com.customer.model.CustomerInfo;

/**
 * @author anamika.gupta created_on : 22-Dec-2016
 **/
@Component
public class CustomerRegistrationDaoImpl implements CustomerRegistrationDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void insertCustomer(CustomerInfo customerInfo) {
		sqlSession.insert("customerRegistration.insertCustomer", customerInfo);
	}

	@Override
	public CustomerInfo getCustomerInfoByEmailId(String emailId) {
		return sqlSession.selectOne("customerRegistration.getCustomerInfoByEmailId", emailId);
	}

}
