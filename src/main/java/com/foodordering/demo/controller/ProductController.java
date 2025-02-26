package com.foodordering.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodordering.demo.constants.Constants;
import com.foodordering.demo.dto.ProductRequestDTO;
import com.foodordering.demo.dto.ProductResponseDTO;
import com.foodordering.demo.dto.ResponseDTO;
import com.foodordering.demo.exception.ErrorResponse;
import com.foodordering.demo.exception.StoreNotFoundException;
import com.foodordering.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ResponseDTO> saveProductDetails(@RequestBody ProductRequestDTO productRequestDto) {

		productService.saveProductDetails(productRequestDto);

		return new ResponseEntity<ResponseDTO>(new ResponseDTO("product saved successfuly", 200), HttpStatus.ACCEPTED);

	}

	
	@GetMapping("/stores/{storeId}/products") 
	public ResponseEntity<ProductResponseDTO> getProductsByStore(@PathVariable("storeId") Integer storeId,
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize){
		ProductResponseDTO productResponseDto = productService.getProductDetailsByStoreId(storeId,pageNo, pageSize);
		return new ResponseEntity<ProductResponseDTO>(productResponseDto, HttpStatus.OK );
	}
	
	
//	@GetMapping("/stores/{storeId}/products")
//	public String getProductsByStore(@PathVariable("storeId") String storeId) {
//		
//		return "ID: " + storeId;
//	}
}
