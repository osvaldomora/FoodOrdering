package com.foodordering.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodordering.demo.dto.request.UserReq;
import com.foodordering.demo.service.IUserService;


@RestController
@RequestMapping("/users/v1")
public class UserController {
	@Autowired
	private IUserService userService;



	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> users(@RequestBody UserReq userReq) {
		
		System.out.println("osvaldo");

		return new ResponseEntity<>(userService.findByNameAndPassword(userReq.getName(), userReq.getPassword()),
				HttpStatus.OK);

	}
	
}
