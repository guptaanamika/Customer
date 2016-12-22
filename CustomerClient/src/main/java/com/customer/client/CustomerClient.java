package com.customer.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Timer;

import lombok.extern.slf4j.Slf4j;

import org.apache.mina.http.api.HttpMethod;

import com.customer.exception.CustomerException;
import com.customer.exception.ExceptionParser;
import com.customer.manager.CustomerService;
import com.customer.request.BookRideRequest;
import com.customer.request.CancelRideRequest;
import com.customer.request.GetTripHistoryRequest;
import com.customer.request.LabelAddressRequest;
import com.customer.request.RaiseComplaintRequest;
import com.customer.request.RateDriverRequest;
import com.customer.request.RegisterCustomerRequest;
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
import com.customer.response.RegisterCustomerResponse;
import com.customer.response.RemovePaymentInstrumentResponse;
import com.customer.response.ScheduleRideResponse;
import com.customer.response.SendAlertResponse;
import com.customer.response.SignInCustomerResponse;
import com.customer.service.model.ServiceResponse;
import com.customer.service.model.ServiceUri;
import com.customer.utils.ClientDetails;
import com.customer.utils.HttpClientEntity;
import com.customer.utils.HttpClientFactory;
import com.customer.utils.HttpUtil;
import com.customer.utils.IdleConnectionMonitor;
import com.fasterxml.jackson.core.type.TypeReference;

@Slf4j
public class CustomerClient implements CustomerService {

	private ClientDetails clientDetails;
	private HttpClientEntity httpClientEntity;
	private HttpClientFactory httpClientFactory = HttpClientFactory.getInstance();
	private Timer timer;

	public CustomerClient(String serviceHostUrl, String clientName, String clientKey) throws Exception {
		ClientDetails details = new ClientDetails();
		details.setUrl(serviceHostUrl);
		details.setClientName(clientName);
		details.setClientKey(clientKey);
		this.clientDetails = details;
		intializeHttpClient(details);
		initializeIdleConnectionMonitor();

	}

	public CustomerClient(ClientDetails clientDetails) throws Exception {
		this.clientDetails = clientDetails;
		intializeHttpClient(clientDetails);
		initializeIdleConnectionMonitor();
	}

	private void intializeHttpClient(ClientDetails clientDetails) throws UnrecoverableKeyException,
			KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, IOException {
		this.httpClientEntity = httpClientFactory.createHttpClient(clientDetails);
	}

	private void initializeIdleConnectionMonitor() {
		IdleConnectionMonitor monitor = new IdleConnectionMonitor();
		monitor.setMonitorName("SDMoneyClient");
		monitor.setConnMgr(httpClientEntity.getConnManager());
		timer = new Timer(true);
		timer.scheduleAtFixedRate(monitor, 0, IdleConnectionMonitor.MONITOR_RATE);
	}

	private String createCompleteUrl(String relativeUrl) {
		return clientDetails.getUrl() + relativeUrl;
	}

	@SuppressWarnings({ "unchecked" })
	private <T, R> R processPostRequest(String requestUri, T request, TypeReference<ServiceResponse<R>> typeReference)
			throws CustomerException {

		ServiceResponse<R> responseBody = (ServiceResponse<R>) HttpUtil.getInstance().processHttpRequest(requestUri,
				typeReference, request, HttpMethod.POST, httpClientEntity.getHttpClient(), clientDetails);
		CustomerException exception = responseBody.getException();
		if (exception != null) {
			log.error(exception.getMessage());
			ExceptionParser.parseException(exception);
		}
		R json = responseBody.getResponse();

		return json;
	}

	@SuppressWarnings({ "unchecked" })
	private <T, R> R processGetRequest(String requestUri, T request, TypeReference<ServiceResponse<R>> typeReference)
			throws CustomerException {

		ServiceResponse<R> responseBody = (ServiceResponse<R>) HttpUtil.getInstance().processHttpRequest(requestUri,
				typeReference, request, HttpMethod.GET, httpClientEntity.getHttpClient(), clientDetails);
		CustomerException exception = responseBody.getException();
		if (exception != null) {
			log.error(exception.getMessage());
			ExceptionParser.parseException(exception);
		}
		R json = responseBody.getResponse();

		return json;
	}

	@Override
	public BookRideResponse bookRide(BookRideRequest bookrideRequest) {
		String requestUri = createCompleteUrl(ServiceUri.BOOK_RIDE);
		return processPostRequest(requestUri, bookrideRequest, new TypeReference<ServiceResponse<BookRideResponse>>() {
		});
	}

	@Override
	public CancelRideResponse cancelRide(CancelRideRequest cancelRideRequest) {
		String requestUri = createCompleteUrl(ServiceUri.CANCEL_RIDE);
		return processPostRequest(requestUri, cancelRideRequest,
				new TypeReference<ServiceResponse<CancelRideResponse>>() {
				});
	}

	@Override
	public GetTripHistoryResponse getTripHistory(GetTripHistoryRequest getTripHistoryRequest) {
		String requestUri = createCompleteUrl(ServiceUri.GET_TRIP_HISTORY);
		return processGetRequest(requestUri, getTripHistoryRequest,
				new TypeReference<ServiceResponse<GetTripHistoryResponse>>() {
				});
	}

	@Override
	public LabelAddressResponse labelAddress(LabelAddressRequest labelAddressRequest) {
		String requestUri = createCompleteUrl(ServiceUri.LABEL_ADDRESS);
		return processPostRequest(requestUri, labelAddressRequest,
				new TypeReference<ServiceResponse<LabelAddressResponse>>() {
				});
	}

	@Override
	public RaiseComplaintResponse raiseComplaint(RaiseComplaintRequest raiseComplaintRequest) {
		String requestUri = createCompleteUrl(ServiceUri.RAISE_COMPLAINT);
		return processPostRequest(requestUri, raiseComplaintRequest,
				new TypeReference<ServiceResponse<RaiseComplaintResponse>>() {
				});
	}

	@Override
	public RateDriverResponse rateDriver(RateDriverRequest rateDriverRequest) {
		String requestUri = createCompleteUrl(ServiceUri.RATE_DRIVER);
		return processPostRequest(requestUri, rateDriverRequest,
				new TypeReference<ServiceResponse<RateDriverResponse>>() {
				});
	}

	@Override
	public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) {
		String requestUri = createCompleteUrl(ServiceUri.REGISTER_CUSTOMER);
		return processPostRequest(requestUri, registerCustomerRequest,
				new TypeReference<ServiceResponse<RegisterCustomerResponse>>() {
				});
	}

	@Override
	public RemovePaymentInstrumentResponse removePaymentInstrument(
			RemovePaymentInstrumentRequest removePaymentInstrumentRequest) {
		String requestUri = createCompleteUrl(ServiceUri.REMOVE_PAYMENT_INSTRUMENT);
		return processPostRequest(requestUri, removePaymentInstrumentRequest,
				new TypeReference<ServiceResponse<RemovePaymentInstrumentResponse>>() {
				});
	}

	@Override
	public ScheduleRideResponse schedulerRide(ScheduleRideRequest schedulerRideRequest) {
		String requestUri = createCompleteUrl(ServiceUri.SCHEDULE_RIDE);
		return processPostRequest(requestUri, schedulerRideRequest,
				new TypeReference<ServiceResponse<ScheduleRideResponse>>() {
				});
	}

	@Override
	public SendAlertResponse sendAlert(SendAlertRequest sendAlertRequest) {
		String requestUri = createCompleteUrl(ServiceUri.SEND_ALERT);
		return processPostRequest(requestUri, sendAlertRequest,
				new TypeReference<ServiceResponse<SendAlertResponse>>() {
				});
	}

	@Override
	public SignInCustomerResponse signInCustomer(SignInCustomerRequest signInCustomerRequest) {
		String requestUri = createCompleteUrl(ServiceUri.SIGN_IN_CUSTOMER);
		return processPostRequest(requestUri, signInCustomerRequest,
				new TypeReference<ServiceResponse<SignInCustomerResponse>>() {
				});
	}

}
