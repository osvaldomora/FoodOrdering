package com.foodordering.demo.service;


import com.foodordering.demo.dto.ProductRequestDTO;
import com.foodordering.demo.dto.ProductResponseDTO;

public interface ProductService {

	void saveProductDetails(ProductRequestDTO productRequestDto);

	ProductResponseDTO getProductDetailsByStoreId(Integer storeId,Integer pageNo,Integer pageSize);
	
}
