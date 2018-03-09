package com.example.boot.again.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.example.boot.again.pojo.Catalog;
import com.example.boot.again.pojo.Product;
import com.example.boot.again.service.CatalogService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = {"/api/catalogs", "/api/v1/catalogs"})
public class CatalogController {

	private final CatalogService catalogService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Catalog addNewCatalog(@RequestBody Catalog catalog) {
		return catalogService.addNewCatalog(catalog);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Catalog> getCatalog() {
		return catalogService.findAll();
	}
	
	@DeleteMapping(value = "/{deleteCatalogId}")
	public ResponseEntity<String> deleteCatalog(@PathVariable Long deleteCatalogId) {
		catalogService.deleteCatalog(deleteCatalogId);
		return new ResponseEntity<String>("Catalog Deleted Successfully" , HttpStatus.OK);
	}
	

	@GetMapping(value="/search",produces = APPLICATION_JSON_UTF8_VALUE)
	public List<Catalog> searchCatalog(@RequestParam("name") String searchCatalogName)
	{
		return catalogService.searchCatalog(searchCatalogName);
	}
	
	@GetMapping(value="/count",produces = APPLICATION_JSON_UTF8_VALUE)
	public Long countCatalog()
	{
		return catalogService.countCatalog();
	}
}
