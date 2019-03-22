package com.cigma.java.stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigma.java.stock.entities.StockCategorie;
import com.cigma.java.stock.entities.StockSupplier;
import com.cigma.java.stock.repositories.IStockSupplierRepo;


@Service
public class StockSupplierService {

	
	@Autowired
	private IStockSupplierRepo stockSupplierRepo;
	
	
	public void saveSupplier(StockSupplier sc) {
		stockSupplierRepo.save(sc);
		
	}
	
	public void delete(Integer id ) {
		if (stockSupplierRepo.getOne(id)!=null) {
			stockSupplierRepo.deleteById(id);
		}
	}
	
	public void addStockSupplier(StockSupplier sup) {
		stockSupplierRepo.save(sup);
	}
	
	public List<StockSupplier> findStockSupplierByName(String supname) {
		return stockSupplierRepo.findStockSupplierByName(supname);
		
	}
	
	public StockSupplier getSupplierById(Integer id) {
		return stockSupplierRepo.getOne(id) ;
	}
	
}
