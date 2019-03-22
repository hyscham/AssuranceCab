package com.cigma.java.stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigma.java.stock.entities.StockCategorie;
import com.cigma.java.stock.repositories.IStockCategoryRepo;

@Service
public class StockCategoryService  {
	
	@Autowired
	private IStockCategoryRepo iStockCategoryRepo;
	
	public void saveCategory(StockCategorie sc) {
		iStockCategoryRepo.save(sc);
		
	}
	
	public void addStockCategory(StockCategorie cat) {
		iStockCategoryRepo. save(cat);
	}
	
	public List<StockCategorie> searchStockCategory(String cat) {
		return iStockCategoryRepo.findStockCategoryByName(cat);
		
	}
	
	
	
}
