package com.foodordering.demo.dto.service;

import com.foodordering.demo.dto.UserDto;
import com.foodordering.demo.entity.User;

public interface IMappingService {
	
	UserDto mappingUSer(User user);

}
