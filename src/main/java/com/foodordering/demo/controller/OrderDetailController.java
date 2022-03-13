package com.foodordering.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodordering.demo.dto.OrderRequestDTO;
import com.foodordering.demo.dto.OrderResponseDTO;
import com.foodordering.demo.service.OrderDetailService;



@Controller
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderService;
	
	@PostMapping("/orderDetails")
	public ResponseEntity<OrderResponseDTO> saveOrderDetails(@RequestBody OrderRequestDTO orderRequestDto){
		
		OrderResponseDTO orderResponseDto = orderService.saveOrderDetails(orderRequestDto);
		
		return new ResponseEntity<OrderResponseDTO>(orderResponseDto, HttpStatus.OK);
	}
}
