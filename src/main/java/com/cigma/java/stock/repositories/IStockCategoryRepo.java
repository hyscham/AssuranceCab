package com.cigma.java.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cigma.java.stock.entities.StockCategorie;


@Repository
public interface IStockCategoryRepo extends JpaRepository<StockCategorie, Integer> {
	
	@Query("SELECT c FROM StockCategorie c WHERE categoryDescription LIKE '%mc%'")
	public List<StockCategorie> findStockCategoryByName (@Param("categoryKeyWord") String mc);
}
