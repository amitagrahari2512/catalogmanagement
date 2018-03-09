package com.example.boot.again.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.boot.again.exception.CatalogException;
import com.example.boot.again.pojo.Catalog;
import com.example.boot.again.pojo.Product;
import com.example.boot.again.repository.CatalogRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

	private final CatalogRepository catalogRepository;

	@Override
	public Catalog addNewCatalog(Catalog catalog) {

		Set<Product> listOfProducts = catalog.getProducts();
		Optional<Set<Product>> checkNullProduct = Optional.ofNullable(listOfProducts);
		if (checkNullProduct.isPresent()) {
			listOfProducts.forEach(product->product.setCatalog(catalog));
		}

		return catalogRepository.save(catalog);
	}

	@Override
	public List<Catalog> findAll() {
		return catalogRepository.findAll();
	}

	@Override
	public void deleteCatalog(Long deleteCatalogId) {
		catalogRepository.delete(deleteCatalogId);
	}

	@Override
	public List<Catalog> searchCatalog(String searchCatalogName) {
		List<Catalog> listCatalog = catalogRepository.findByCatalogNameContaining(searchCatalogName.toLowerCase());
		if (listCatalog.size() > 0) {
			return listCatalog;
		} else {
			throw new CatalogException("No Catalog Found");
		}
	}

	@Override
	public Long countCatalog() {
		return catalogRepository.count();
	}

}
