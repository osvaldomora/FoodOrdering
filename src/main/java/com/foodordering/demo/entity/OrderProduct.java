package com.foodordering.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProduct {
	private Integer productId;
	private int quantity;
	private double productPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "OrderProduct [productId=" + productId + ", quantity=" + quantity + ", productPrice=" + productPrice
				+ "]";
	}
	
	
}
