package com.customer.api;

import com.customer.request.RemovePaymentInstrumentRequest;
import com.customer.response.RemovePaymentInstrumentResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface RemovePaymentInstrumentActivity {

	public RemovePaymentInstrumentResponse removePaymentInstrument(
			RemovePaymentInstrumentRequest removePaymentInstrumentRequest);

}
