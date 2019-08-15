package com.en.ws.entities;

import com.en.ws.enums.CAT;
import com.en.ws.enums.VAT;

public class Product {
	
	// Properties
	private Integer code;
	private String name;
	private String desc;
	private VAT vat;
	private Double price;
	private Integer stock;
	private Integer totalSells;
	private CAT category;
	
	/**
	 * Product constructor
	 * @param code
	 * @param name
	 * @param desc
	 * @param vat
	 * @param price
	 * @param stock
	 * @param totalSells
	 * @param category
	 */
	public Product(Integer code, String name, String desc, VAT vat, Double price, Integer stock, CAT category) {
		super();
		this.code = code;
		this.name = name;
		this.desc = desc;
		this.vat = vat;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	// Setters and Getters
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public VAT getVat() {
		return vat;
	}
	public void setVat(VAT vat) {
		this.vat = vat;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getTotalSells() {
		return totalSells;
	}
	public void setTotalSells(Integer totalSells) {
		this.totalSells = totalSells;
	}
	public CAT getCategory() {
		return category;
	}
	public void setCategory(CAT category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format(
				"Product [code=%s, name=%s, desc=%s, vat=%s, price=%s, stock=%s, totalSells=%s, category=%s]", code,
				name, desc, vat, price, stock, totalSells, category);
	}

}
