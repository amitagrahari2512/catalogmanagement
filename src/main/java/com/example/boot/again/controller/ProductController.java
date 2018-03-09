package com.example.boot.again.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.again.pojo.Product;
import com.example.boot.again.repository.CatalogRepository;
import com.example.boot.again.service.ProductService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = { "/api/products", "/api/v1/products" })
public class ProductController {

	private final ProductService productService;
	
	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE , produces = APPLICATION_JSON_UTF8_VALUE)
	public Product addProducts(@RequestBody Product product) {
		return productService.addProducts(product);
	}
	
	@DeleteMapping(value = "/{deleteProductId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long deleteProductId) {
			productService.deleteProduct(deleteProductId);
			return new ResponseEntity<String>("Product Deleted Successfully" , HttpStatus.OK);
	}
	@GetMapping(value="/search",produces = APPLICATION_JSON_UTF8_VALUE)
	public List<Product> searchProduct(@RequestParam("name") String searchProductName)
	{
		return productService.searchProduct(searchProductName);
	}
	
	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/count",produces = APPLICATION_JSON_UTF8_VALUE)
	public Long countProduct()
	{
		return productService.countProduct();
	}
	
}
