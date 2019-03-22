package com.cigma.java.stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="ST_CATEGORY")
public class StockCategorie {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer categoryID;
	
    @Size(min=2, max=8)
	@NotNull(message="Category Stock Description courte [2 - 8]")
	String categoryShdes;
	
	@NotNull(message="Category Stock Enabled")
   	Boolean isActive=false;
	
	@NotNull
    @Size(min=2, max=30)
	String categoryDescription;
	
	
	public StockCategorie() {
	}

	public Integer getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}


	public String getCategoryShdes() {
		return categoryShdes;
	}


	public void setCategoryShdes(String categoryShdes) {
		this.categoryShdes = categoryShdes;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
}
