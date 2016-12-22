package com.customer.exception;

import java.lang.reflect.InvocationTargetException;

public class ExceptionParser {

	public static void parseException(CustomerException exception) {
		try {
			throw ((CustomerException) exception.getExceptionCause().getConstructor(String.class)
					.newInstance(exception.getMessage())).withErrorCode(exception.getErrorCode());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

}
