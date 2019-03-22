
package com.cigma.java.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cigma.java.stock.entities.StockSupplier;

public interface IStockSupplierRepo extends JpaRepository<StockSupplier, Integer> {
	
	@Query("SELECT s FROM StockSupplier s WHERE lower(s.supplierName) LIKE %?1% ")
	public List<StockSupplier> findStockSupplierByName (String mc);
//	@Param("supplierName") 
}
