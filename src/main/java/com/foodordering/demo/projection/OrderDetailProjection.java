package com.foodordering.demo.projection;

import com.foodordering.demo.entity.OrderStatus;
import com.foodordering.demo.entity.Store;

public class OrderDetailProjection {
	
	
	


	private Store store;
	
	private OrderStatus status;



	public OrderDetailProjection(Store store, OrderStatus status) {
		super();
		this.store = store;
		this.status = status;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	

}
