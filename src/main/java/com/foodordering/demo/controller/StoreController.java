package com.foodordering.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodordering.demo.dto.StoreResponseDTO;
import com.foodordering.demo.service.StoreService;


@RestController
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("/stores")
	public ResponseEntity<StoreResponseDTO> getAllStoreDetails(){
		StoreResponseDTO storeResponseDto = storeService.getAllStoreDetails();
		
		return new ResponseEntity<StoreResponseDTO>(storeResponseDto, HttpStatus.OK);
	}
	
	//@GetMapping("/stores/{storeId}/products")
	
}
