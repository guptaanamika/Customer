package com.customer.api;

import com.customer.request.LabelAddressRequest;
import com.customer.response.LabelAddressResponse;


/**
   @author anamika.gupta
   created_on : 21-Dec-2016
 **/
public interface LabelAddressActivity {

	public LabelAddressResponse labelAddress(LabelAddressRequest labelAddressRequest);

}
