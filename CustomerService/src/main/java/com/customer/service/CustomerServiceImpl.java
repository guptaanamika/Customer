package com.customer.service;

import lombok.experimental.Delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.api.RegisterCustomerActivity;
import com.customer.manager.CustomerService;
import com.customer.request.BookRideRequest;
import com.customer.request.CancelRideRequest;
import com.customer.request.GetTripHistoryRequest;
import com.customer.request.LabelAddressRequest;
import com.customer.request.RaiseComplaintRequest;
import com.customer.request.RateDriverRequest;
import com.customer.request.RemovePaymentInstrumentRequest;
import com.customer.request.ScheduleRideRequest;
import com.customer.request.SendAlertRequest;
import com.customer.request.SignInCustomerRequest;
import com.customer.response.BookRideResponse;
import com.customer.response.CancelRideResponse;
import com.customer.response.GetTripHistoryResponse;
import com.customer.response.LabelAddressResponse;
import com.customer.response.RaiseComplaintResponse;
import com.customer.response.RateDriverResponse;
import com.customer.response.RemovePaymentInstrumentResponse;
import com.customer.response.ScheduleRideResponse;
import com.customer.response.SendAlertResponse;
import com.customer.response.SignInCustomerResponse;

/**
 * @author anamika.gupta created_on : 22-Dec-2016
 **/
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Delegate
	private RegisterCustomerActivity registerCustomerActivity;

	@Override
	public BookRideResponse bookRide(BookRideRequest bookrideRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CancelRideResponse cancelRide(CancelRideRequest cancelRideRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetTripHistoryResponse getTripHistory(GetTripHistoryRequest getTripHistoryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LabelAddressResponse labelAddress(LabelAddressRequest labelAddressRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RaiseComplaintResponse raiseComplaint(RaiseComplaintRequest raiseComplaintRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RateDriverResponse rateDriver(RateDriverRequest rateDriverRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemovePaymentInstrumentResponse removePaymentInstrument(
			RemovePaymentInstrumentRequest removePaymentInstrumentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleRideResponse schedulerRide(ScheduleRideRequest schedulerRideRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendAlertResponse sendAlert(SendAlertRequest sendAlertRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInCustomerResponse signInCustomer(SignInCustomerRequest signInCustomerRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
