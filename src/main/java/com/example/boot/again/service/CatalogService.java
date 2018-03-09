package com.example.boot.again.service;

import java.util.List;

import com.example.boot.again.pojo.Catalog;

public interface CatalogService {

	Catalog addNewCatalog(Catalog catalog);

	List<Catalog> findAll();
	
	void deleteCatalog(Long deleteCatalogId);
	
	List<Catalog> searchCatalog(String searchCatalogName);
	
	Long countCatalog();
}
