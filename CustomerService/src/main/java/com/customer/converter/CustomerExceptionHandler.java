package com.customer.converter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.customer.exception.CustomerException;
import com.customer.exception.InternalServerException;

/**
 * @author anamika.gupta
 **/
@Component
@Slf4j
public class CustomerExceptionHandler {

	public void handleExceptions(Throwable exception) throws CustomerException {

		log.error("Unknown_Exception" + exception.getMessage(), exception);
		throw new InternalServerException("Some internal error occured , msg :" + exception.getMessage());
	}
}
