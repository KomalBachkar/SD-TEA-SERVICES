package com.sagar.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String mobileNumber;
	private String address;
	private String pinCode;

	


}
