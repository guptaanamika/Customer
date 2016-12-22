package com.customer.api;

import com.customer.request.SendAlertRequest;
import com.customer.response.SendAlertResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface SendAlertActivity {

	public SendAlertResponse sendAlert(SendAlertRequest sendAlertRequest);

}
