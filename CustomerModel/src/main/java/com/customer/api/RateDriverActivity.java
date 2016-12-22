package com.customer.api;

import com.customer.request.RateDriverRequest;
import com.customer.response.RateDriverResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface RateDriverActivity {

	public RateDriverResponse rateDriver(RateDriverRequest rateDriverRequest);

}
