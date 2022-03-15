package com.foodordering.demo.dto;

import com.foodordering.demo.entity.ProductCategory;
import com.foodordering.demo.enumeration.ProdCategory;

public class ProductRequestDTO {
	
	private String productName;
	private Double productPrice;
	private String productDescription;
	private ProdCategory productCategory;//String productCategory;
	private boolean isAvailable;	
	private Integer storeId;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public ProdCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProdCategory productCategory) {
		this.productCategory = productCategory;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	
	
	
}
