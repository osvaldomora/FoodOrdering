package com.foodordering.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordering.demo.dto.UserRequestLoginDTO;
import com.foodordering.demo.dto.UserResponseDTO;
import com.foodordering.demo.repo.UserRepo;
import com.foodordering.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserResponseDTO requestUserLogin(UserRequestLoginDTO userRequestLoginDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
