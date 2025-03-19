package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.Pojo.Product;
import com.app.Pojo.User;
import com.app.dto.CommonApiResponse;

public interface ProductService {

	ResponseEntity<CommonApiResponse> getProducts(int id);

	ResponseEntity<CommonApiResponse> addProduct(User user, Product product);

	

}
