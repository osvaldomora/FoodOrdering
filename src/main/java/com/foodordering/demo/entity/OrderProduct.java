package com.foodordering.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProduct {
	private Integer productId;
	private int quantity;
	private double productPrice;
}
