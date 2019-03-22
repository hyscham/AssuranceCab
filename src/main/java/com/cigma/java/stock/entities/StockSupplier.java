package com.cigma.java.stock.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ST_SUPPLIER")
public class StockSupplier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer supplierId;
	
	
	@Size(min=3, max=20)
	@NotNull(message="Entrer le nom du fournisseur")
	String supplierName;
	
	
	@Size(min=3, max=50)
	@NotNull(message="Entrer des informations sur le fournisseur")
	String supplierShdes;
	
	public StockSupplier() {
	
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierShdes() {
		return supplierShdes;
	}

	public void setSupplierShdes(String supplierShdes) {
		this.supplierShdes = supplierShdes;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	
	
	
	
	
	

}
