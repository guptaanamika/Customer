package com.customer.api;

import com.customer.request.GetTripHistoryRequest;
import com.customer.response.GetTripHistoryResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface GetTripHistoryActivity {

	public GetTripHistoryResponse getTripHistory(GetTripHistoryRequest getTripHistoryRequest);
}
