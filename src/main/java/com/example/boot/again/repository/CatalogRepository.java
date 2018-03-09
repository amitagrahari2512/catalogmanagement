package com.example.boot.again.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.boot.again.pojo.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Long>{

	@Query("Select c from Catalog c where lower(c.catalogName) like %:searchCatalogName%")
    List<Catalog> findByCatalogNameContaining(@Param("searchCatalogName") String searchCatalogName);
}
