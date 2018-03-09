package com.example.boot.again.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot.again.exception.ProductException;
import com.example.boot.again.pojo.Product;
import com.example.boot.again.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productDetailRepository;

	@Override
	public Product addProducts(Product product) {
		return productDetailRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long deleteProductId) {
		Product product = productDetailRepository.findOne(deleteProductId);
		Optional<Product> checkNullProduct = Optional.ofNullable(product);  
		if(checkNullProduct.isPresent()  && product.getProductId() == deleteProductId)
		{
		   productDetailRepository.deleteProduct(deleteProductId);
		}
		else
		{
			throw new ProductException("Product not present");
		}
	}
	

	@Override
	public List<Product> searchProduct(String searchProductName) {
		List<Product> listProduct =  productDetailRepository.findByProductNameContaining(searchProductName.toLowerCase());
		if(listProduct.size()>0)
		{
			return listProduct;
		}
		else
		{
			throw new ProductException("No Product Found");
		}
	}
	
	@Override
	public List<Product> getAllProducts(){
		return productDetailRepository.findAll();
	}

	@Override
	public Long countProduct() {
		return productDetailRepository.count();
	}

}
