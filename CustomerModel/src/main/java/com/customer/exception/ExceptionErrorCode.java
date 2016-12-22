package com.customer.exception;

public enum ExceptionErrorCode {

	INTERNAL_ERROR(400), DEFAULT_VALIDATION(401), CLIENT_INTERNAL(402), NO_SUCH_ATTRIBUTE(404), SERVER_INTERNAL(403), NO_SUCH_VISIT(
			405);

	private final Integer errorCode;

	private ExceptionErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
