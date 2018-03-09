package com.example.boot.again.service;

import java.util.List;

import com.example.boot.again.pojo.Product;

public interface ProductService {

	Product addProducts(Product product); 
	void deleteProduct(Long deleteProductId); 
	List<Product> searchProduct(String searchProductName);
	List<Product> getAllProducts();
	Long countProduct();
	
}
