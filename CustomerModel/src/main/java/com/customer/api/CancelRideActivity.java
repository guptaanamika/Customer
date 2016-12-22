package com.customer.api;

import com.customer.request.CancelRideRequest;
import com.customer.response.CancelRideResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface CancelRideActivity {

	public CancelRideResponse cancelRide(CancelRideRequest cancelRideRequest);
}
