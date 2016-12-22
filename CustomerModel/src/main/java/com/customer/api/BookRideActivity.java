package com.customer.api;

import com.customer.request.BookRideRequest;
import com.customer.response.BookRideResponse;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
public interface BookRideActivity {

	public BookRideResponse bookRide(BookRideRequest bookrideRequest);
}
