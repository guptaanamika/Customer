package com.customer.client;

import com.customer.request.RegisterCustomerRequest;
import com.customer.response.RegisterCustomerResponse;
import com.customer.utils.ClientDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author anamika.gupta created_on : 24-Nov-2016
 **/
public class CustomerTest {

	static CustomerClient client;

	public static void main(String[] args) throws Exception {
		ClientDetails clientDetails = new ClientDetails();
		clientDetails.setUrl("http://localhost:8080");
		client = new CustomerClient(clientDetails);

		resgisterCustomer();

	}

	private static void resgisterCustomer() throws JsonProcessingException {
		RegisterCustomerRequest request = new RegisterCustomerRequest("abc", "abc", "01");
		System.out.println(new ObjectMapper().writeValueAsString(request));
		RegisterCustomerResponse response = client.registerCustomer(request);
		System.out.println(new ObjectMapper().writeValueAsString(response));
	}

}
