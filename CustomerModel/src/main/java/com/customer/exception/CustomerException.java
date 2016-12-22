package com.customer.exception;

import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author anamika.gupta created_on : 18-Nov-2016
 **/
@Setter
@JsonIgnoreProperties("stackTrace")
public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = 2772585922930376373L;
	private ExceptionErrorCode errorCode;
	private Class<? extends CustomerException> exceptionCause;

	public CustomerException(Throwable cause) {
		super(cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException() {
	}

	public CustomerException withErrorCode(ExceptionErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;

	}

	public CustomerException(String message, Throwable e) {
		super(message, e);
	}

	public ExceptionErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ExceptionErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public Class<?> getExceptionCause() {
		return exceptionCause;
	}

	public void setExceptionCause(Class<? extends CustomerException> exceptionCause) {
		this.exceptionCause = exceptionCause;
	}

	{
		this.setExceptionCause(this.getClass());
	}

}
