package com.customer.manager;

import com.customer.api.BookRideActivity;
import com.customer.api.CancelRideActivity;
import com.customer.api.GetTripHistoryActivity;
import com.customer.api.LabelAddressActivity;
import com.customer.api.RaiseComplaintActivity;
import com.customer.api.RateDriverActivity;
import com.customer.api.ReceiveAlertActivity;
import com.customer.api.RegisterCustomerActivity;
import com.customer.api.RemovePaymentInstrumentActivity;
import com.customer.api.ScheduleRideActivity;
import com.customer.api.SendAlertActivity;
import com.customer.api.SignInCustomerActivity;

/**
 * @author anamika.gupta created_on : 16-Nov-2016
 **/
public interface CustomerService extends BookRideActivity, CancelRideActivity, GetTripHistoryActivity,
		LabelAddressActivity, RaiseComplaintActivity, RateDriverActivity, ReceiveAlertActivity,
		RegisterCustomerActivity, RemovePaymentInstrumentActivity, ScheduleRideActivity, SendAlertActivity,
		SignInCustomerActivity {

}
