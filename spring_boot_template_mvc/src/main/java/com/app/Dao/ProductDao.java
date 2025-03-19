package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Pojo.Product;
import com.app.Pojo.User;

public interface ProductDao extends JpaRepository<Product, Integer> {
	 List<Product> findByUsers(User user);
}
