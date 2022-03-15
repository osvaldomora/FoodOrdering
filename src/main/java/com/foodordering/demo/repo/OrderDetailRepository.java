package com.foodordering.demo.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodordering.demo.entity.OrderDetail;
import com.foodordering.demo.projection.OrderDetailProjection;
import com.foodordering.demo.projection.OrderDetailView;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

//	List<OrderDetail> findByUserId(Integer userId);

	Page<OrderDetail> findByUserId(Integer userId, Pageable pag);
	
	//projections.
	@Query("SELECT b.status, b.userId FROM OrderDetail b")
    List<Object[]> getStatusAndUserId(); 
    
    //projection with dto class
    @Query("SELECT new com.foodordering.demo.projection.OrderDetailProjection(a.store, a.status) FROM OrderDetail a WHERE a.orderDetailId = :orderDetailId")
    OrderDetailProjection findByStoreAndStatus(Integer orderDetailId);
//    List<OrderDetailProjection> getByStoreAndStatus(Integer orderDetailId);
    
    //projection with interface
    List<OrderDetailView> findAllByUserId(Integer userId);
//    List<OrderDetailView> findByUserId(Integer userId);


}
