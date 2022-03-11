package com.foodordering.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodordering.demo.entity.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Integer>{

}
