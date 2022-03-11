package com.foodordering.demo.service;

import com.foodordering.demo.dto.UserRequestLoginDTO;
import com.foodordering.demo.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO requestUserLogin(UserRequestLoginDTO userRequestLoginDTO);

	

}
