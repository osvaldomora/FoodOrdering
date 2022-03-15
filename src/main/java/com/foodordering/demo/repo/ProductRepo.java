package com.foodordering.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodordering.demo.dto.ProductResponseDTO;
import com.foodordering.demo.entity.Product;
import com.foodordering.demo.entity.Store;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p.productName,productDescription,productPrice FROM Product p WHERE store_storeId = :storeId")
	public List<Product> getProductDetailsByStore(@Param("storeId") Optional<Store> filterStore);
	
//	public List<Product> findByStore(Optional<Store> filterStore,Pageable paging);
	Page<Product> findByStore(Optional<Store> filterStore,Pageable paging);
}
