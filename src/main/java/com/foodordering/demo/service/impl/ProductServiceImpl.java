package com.foodordering.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foodordering.demo.dto.ProductDetails;
import com.foodordering.demo.dto.ProductRequestDTO;
import com.foodordering.demo.dto.ProductResponseDTO;
import com.foodordering.demo.entity.OrderDetail;
import com.foodordering.demo.entity.Product;
import com.foodordering.demo.entity.ProductCategory;
import com.foodordering.demo.entity.Store;
import com.foodordering.demo.exception.StoreNotFoundException;
import com.foodordering.demo.repo.ProductRepo;
import com.foodordering.demo.repo.StoreRepo;
import com.foodordering.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	StoreRepo storeRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void saveProductDetails(ProductRequestDTO productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		
		product.setProductCategory(ProductCategory.valueOf(productRequestDto.getProductCategory()));
		
		
		Optional<Store> storeOptional = storeRepo.findById(productRequestDto.getStoreId());
		
		if(storeOptional.isEmpty()) {
			throw new StoreNotFoundException("Store not found : " + productRequestDto.getStoreId());
		}
			
		product.setStore(storeOptional.get());
		productRepo.save(product);
	}

	@Override
	public ProductResponseDTO getProductDetailsByStoreId(Integer storeId,Integer pageNo,Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
//		Page<OrderDetail> orderPage = orderDetailRep.findByUserId(userId,paging);
		Optional<Store> filterStore = storeRepo.findById(storeId);
		Page<Product> productPage = productRepo.findByStore(filterStore,paging);
		List<Product> productList = productPage.getContent();
		
		List<ProductDetails> productDetailList = productList.stream().map(product -> {
			ProductDetails productDetails = new ProductDetails();
			BeanUtils.copyProperties(product, productDetails);
			return productDetails;
		}).collect(Collectors.toList());
		
		ProductResponseDTO productResponseDTO = new ProductResponseDTO("Fetch of products by id successfull", 200);
		productResponseDTO.setProductList(productDetailList);
		
		return productResponseDTO;
		
	}

}
