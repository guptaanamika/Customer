package com.customer.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author anamika.gupta created_on : 21-Dec-2016
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerRequest {

	@NotBlank
	@Size(max = 50, message = "The field must be less than " + 50 + " characters")
	@Pattern(regexp = "[^<>~!^()]*", message = "Customer name is not valid")
	private String name;

	@NotBlank
	@Size(max = 50, message = "The field must be less than " + 50 + " characters")
	@Pattern(regexp = "[^<>~!^()]*", message = "Email Id is not valid")
	private String emailId;

	@NotBlank
	@Size(max = 50, message = "The field must be less than " + 50 + " characters")
	@Pattern(regexp = "[0-9]*", message = "Contact Number is not valid")
	private String contactNumber;

}
