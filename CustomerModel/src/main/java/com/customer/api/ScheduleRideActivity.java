package com.customer.api;

import com.customer.request.ScheduleRideRequest;
import com.customer.response.ScheduleRideResponse;


/**
   @author anamika.gupta
   created_on : 21-Dec-2016
 **/
public interface ScheduleRideActivity {

	public ScheduleRideResponse schedulerRide(ScheduleRideRequest schedulerRideRequest);
}
