package com.foodordering.demo.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderRequestDTO {
    
	@NotNull
	private Integer userId;
	@NotNull
	private Integer storeId;
	@Size(min=1, message = "productList must be greater than or equal to 1")

	private List<ProductListOrderDetailDTO> productList;
	
	private double totalPrice;
	private String orderNumber;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public List<ProductListOrderDetailDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductListOrderDetailDTO> productList) {
		this.productList = productList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}
