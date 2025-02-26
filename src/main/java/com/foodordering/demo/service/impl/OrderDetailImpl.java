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

import com.foodordering.demo.dto.OrderRequestDTO;
import com.foodordering.demo.dto.OrderResponseDTO;
import com.foodordering.demo.dto.ProductListOrderDetailDTO;
import com.foodordering.demo.dto.order.detail.OrderDetailDto;
import com.foodordering.demo.dto.service.IMappingService;
import com.foodordering.demo.entity.OrderDetail;
import com.foodordering.demo.entity.OrderProduct;
import com.foodordering.demo.entity.Product;
import com.foodordering.demo.entity.Store;
import com.foodordering.demo.exception.OrderDetailNotFoundException;
import com.foodordering.demo.exception.ProductNotFoundException;
import com.foodordering.demo.exception.StoreNotFoundException;
import com.foodordering.demo.repo.OrderDetailRepository;
import com.foodordering.demo.repo.ProductRepo;
import com.foodordering.demo.repo.StoreRepo;
import com.foodordering.demo.service.OrderDetailService;

@Service
public class OrderDetailImpl implements OrderDetailService{
	@Autowired
	private StoreRepo storeRepo;
	@Autowired
	private OrderDetailRepository orderDetailRep;
	@Autowired
	private IMappingService mapping;
	@Autowired
	private ProductRepo productRepo;
	@Override
	public OrderDetailDto orderdetails(Integer userId, Integer pageNo,Integer pageSize) {
//	       Projection1();
//	       Projection2();
//	       Projection3();
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<OrderDetail> orderPage = orderDetailRep.findByUserId(userId,paging);
		List<OrderDetail> ordersDet =orderPage.getContent();
//		List<OrderDetail> ordersDet =	orderDetailRep.findByUserId(userId);
		System.out.println("list:");
		if(ordersDet.isEmpty())
			throw new OrderDetailNotFoundException("the order history should not be empty");
			
		System.out.println("size:"+ordersDet.size());
		
		return mapping.mappingOrderDetail(ordersDet);
		
		
		
	}
	
	
	private void Projection3() {
		orderDetailRep.findAllByUserId(1).forEach(x->{
			System.out.println("status:"+x.getStatus());
			System.out.println("Storename:"+x.getStore().getStoreName());
				
		});
	}


	private void Projection2() {
		// projection ussing DTO
		System.out.println("projection 2");
		System.out.println(orderDetailRep.findByStoreAndStatus(1).getStore().getStoreName());
		/*orderDetailRep.getByStoreAndStatus(1).stream().forEach(x->{
			System.out.println("status:"+x.getStatus());
			System.out.println("Storename:"+x.getStore().getStoreName());
				
		});*/
		
	}


	private void Projection1() {
		List<Object[]>  order =	orderDetailRep.getStatusAndUserId();
		order.forEach(x->{
			
			
			System.out.println(x[0]);
			System.out.println(x[1]);

		});
	}


	@Override
	public OrderResponseDTO saveOrderDetails(OrderRequestDTO orderRequestDto) {
		
		OrderDetail orderDetail = new OrderDetail();
		
		BeanUtils.copyProperties(orderRequestDto, orderDetail);
		Optional<Store> storeOptional = storeRepo.findById(orderRequestDto.getStoreId());
		
		if(storeOptional.isEmpty()) {
			throw new StoreNotFoundException("Store not Found: " + orderRequestDto.getStoreId());
		}
		
		orderDetail.setStore(storeOptional.get());
		
		List<ProductListOrderDetailDTO> orderProductChanged = orderRequestDto.getProductList();
		List<OrderProduct> orderproductlist = orderProductChanged.stream()
				.map(orderlist -> {
					OrderProduct orderproduct = new OrderProduct();

					Product prod=productRepo.findById(orderlist.getProductId()).orElseThrow(()->new ProductNotFoundException("this product no exist") );
					if(prod.getStore().getStoreId()!=storeOptional.get().getStoreId())
					{
					throw	new ProductNotFoundException("this product does not belong to this store");
					}
                   if(prod.getProductPrice()!=orderlist.getProductPrice()) {
                	   throw	new ProductNotFoundException("price does not match with database data");  
                   }
				BeanUtils.copyProperties(orderlist, orderproduct);
					return orderproduct;
				}).collect(Collectors.toList());
		orderDetail.setOrderProduct(orderproductlist);
		

		
		orderDetailRep.save(orderDetail);
		
		
		OrderResponseDTO orderReponseDto = new OrderResponseDTO("Order saved successfully", 200);
		orderReponseDto.setOrderNumber(orderDetail.getOrderNumber());
		
		return orderReponseDto;
	}
	


}
