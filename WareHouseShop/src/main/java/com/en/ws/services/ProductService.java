package com.en.ws.services;

import java.util.List;

import com.en.ws.entities.Product;

public interface ProductService {

	/**
	 * Saves the product in the database
	 * @param product
	 * @return success
	 */
	boolean create(Product product);
	
	/**
	 * Lists all products in the database
	 * @return product list
	 */
	List<Product> list();
	
	/**
	 * Search the products with the same code, name or category
	 * @param code
	 * @param name
	 * @param category
	 * @return filtered products list
	 */
	List<Product> search(Product filter);
	
	/**
	 * Modifies the product with the code parsed, and changes it for the product parsed
	 * @param code
	 * @param editedProduct
	 * @return success
	 */
	boolean modify(Integer code, Product editedProduct);
	
	/**
	 * Deletes the product with the code parsed
	 * @param code
	 * @return success
	 */
	boolean delete(Integer code);
	
	/**
	 * Tries to sell a certain number of products with the code parsed
	 * @param code
	 * @param num
	 * @return success
	 */
	boolean sell(Integer code, Integer num);
	
	/**
	 * Shows all the sells information
	 */
	void infoSells();
	
}
