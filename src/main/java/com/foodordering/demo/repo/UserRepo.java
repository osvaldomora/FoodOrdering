package com.foodordering.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodordering.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
