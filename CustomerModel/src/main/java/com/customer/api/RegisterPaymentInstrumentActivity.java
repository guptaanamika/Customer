package com.customer.api;

import com.customer.request.RegisterPaymentInstrumentRequest;
import com.customer.response.RegisterPaymentInstrumentResponse;


/**
   @author anamika.gupta
   created_on : 21-Dec-2016
 **/
public interface RegisterPaymentInstrumentActivity {

	public RegisterPaymentInstrumentResponse registerPaymentInstrument(RegisterPaymentInstrumentRequest registerPaymentInstrumentRequest);

}
