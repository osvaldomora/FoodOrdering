package com.foodordering.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO extends ResponseDTO{

	public UserResponseDTO(String message, int statusCode) {
		super(message, statusCode);
		// TODO Auto-generated constructor stub
	}
	
	public List<UserLoginDetails> userList = new ArrayList<>();

	public List<UserLoginDetails> getUserList() {
		return userList;
	}

	public void setUserList(List<UserLoginDetails> userList) {
		this.userList = userList;
	}
	
}
