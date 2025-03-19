package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.Dao.ProductDao;
import com.app.Dao.UserDao;
import com.app.Pojo.Product;
import com.app.Pojo.User;
import com.app.dto.CommonApiResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	@Autowired UserDao userDao;

	
	public ResponseEntity<CommonApiResponse> getProducts(int userId) {
		// TODO Auto-generated method stub
		User user=userDao.getById(userId);
		List<Product> products = productDao.findByUsers(user);
		 CommonApiResponse response = new CommonApiResponse();
	        response.setResponseMessage("Products fetched successfully");
	        response.setData(products);
	        return ResponseEntity.ok(response);
	}


	@Override
	
	public ResponseEntity<CommonApiResponse> addProduct(User user, Product product) {
        // Save product
        productDao.save(product);

        // Associate the product with the user
        user.getProducts().add(product);
        userDao.save(user);
        
        // Return response
        CommonApiResponse response = new CommonApiResponse();
        response.setResponseMessage("Product added successfully");
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

}
