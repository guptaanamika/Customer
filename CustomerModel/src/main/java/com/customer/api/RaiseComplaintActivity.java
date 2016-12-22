package com.customer.api;

import com.customer.request.RaiseComplaintRequest;
import com.customer.response.RaiseComplaintResponse;

/**
   @author anamika.gupta
   created_on : 21-Dec-2016
 **/
public interface RaiseComplaintActivity {

	public RaiseComplaintResponse raiseComplaint(RaiseComplaintRequest raiseComplaintRequest);
}
