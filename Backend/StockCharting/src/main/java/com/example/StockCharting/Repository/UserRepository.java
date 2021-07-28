package com.example.StockCharting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StockCharting.Entity.User1;

public interface UserRepository  extends JpaRepository<User1,Long> {
   User1 findByName(String name);
}