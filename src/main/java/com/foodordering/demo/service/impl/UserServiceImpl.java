package com.foodordering.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordering.demo.dto.UserDto;
import com.foodordering.demo.dto.service.IMappingService;
import com.foodordering.demo.entity.User;
import com.foodordering.demo.exception.UserNotFoundException;
import com.foodordering.demo.repo.UserRepo;
import com.foodordering.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;
	@Autowired
	IMappingService mapping;
	
	@Override
	public UserDto findByNameAndPassword(String name, String pass) {
		
		Optional<User> user=	userRepo.findByUsernameAndPassword(name, pass);
//				.orElseThrow(() -> new UserNotFoundException("User not found"));
		
        if(!user.isPresent())
		    throw new UserNotFoundException("User not found");
        
		UserDto userDto=mapping.mappingUSer(user.get());
		System.out.println(userDto);
		return userDto;
	}

}
