package com.example.boot.again.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.boot.again.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("Select c from Product c where lower(c.productName) like %:searchProductName%")
    List<Product> findByProductNameContaining(@Param("searchProductName") String searchProductName);
	
	@Transactional
	@Modifying
	@Query("delete from Product  where productid = :productid")
	 void deleteProduct(@Param("productid") Long productid);
	
}
