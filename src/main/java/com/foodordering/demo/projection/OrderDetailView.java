package com.foodordering.demo.projection;

import com.foodordering.demo.entity.OrderStatus;
import com.foodordering.demo.entity.Store;

public interface OrderDetailView {

	Store getStore();
	OrderStatus getStatus();

}
