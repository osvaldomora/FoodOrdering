package com.foodordering.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodordering.demo.dto.UserRequestLoginDTO;
import com.foodordering.demo.dto.UserResponseDTO;
import com.foodordering.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user/login")
	public ResponseEntity<UserResponseDTO> userLogin(@RequestBody UserRequestLoginDTO userRequestLoginDTO){
		
		UserResponseDTO userResponseDTO = userService.requestUserLogin(userRequestLoginDTO);
		
		
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);

	}
	
}
