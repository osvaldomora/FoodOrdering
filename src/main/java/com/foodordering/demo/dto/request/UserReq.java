package com.foodordering.demo.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserReq {
	@NotEmpty(message="product name should not be empty")
	private String name;
	
//	@NotNull @NotEmpty
	@Size(min=1, message = "store id must be greater than or equal to 1")
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
