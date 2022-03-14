package com.foodordering.demo.service;

import com.foodordering.demo.dto.order.detail.OrderDetailDto;



public interface OrderDetailService {
	
	OrderDetailDto orderdetails(Integer userId, Integer pageNo,Integer pageSize);
	 
	 
	 

}
