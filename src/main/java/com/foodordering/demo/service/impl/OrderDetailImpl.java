package com.foodordering.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foodordering.demo.dto.order.detail.OrderDetailDto;
import com.foodordering.demo.dto.service.IMappingService;
import com.foodordering.demo.entity.OrderDetail;
import com.foodordering.demo.exception.OrderDetailNotFoundException;
import com.foodordering.demo.repo.OrderDetailRepository;
import com.foodordering.demo.service.OrderDetailService;

@Service
public class OrderDetailImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRep;
	@Autowired
	private IMappingService mapping;
	@Override
	public OrderDetailDto orderdetails(Integer userId, Integer pageNo,Integer pageSize) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<OrderDetail> orderPage = orderDetailRep.findByUserId(userId,paging);
		List<OrderDetail> ordersDet =orderPage.getContent();
//		List<OrderDetail> ordersDet =	orderDetailRep.findByUserId(userId);
		if(ordersDet.isEmpty())
			new OrderDetailNotFoundException("the order history is empty");
			
		System.out.println("size:"+ordersDet.size());
		
		return mapping.mappingOrderDetail(ordersDet);
	}
	


}
