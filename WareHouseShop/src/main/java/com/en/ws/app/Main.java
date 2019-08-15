package com.en.ws.app;

import java.util.List;

import com.en.ws.entities.Product;
import com.en.ws.enums.CAT;
import com.en.ws.enums.VAT;
import com.en.ws.menu.Menu;
import com.en.ws.services.ProductService;
import com.en.ws.services.ProductServiceImpl;

/**
 * 
 * @author uriel
 *
 */
public class Main {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Variables
		Product product = null;
		ProductService ps;
		List<Product> products;
		
		Menu.MainMenu();
		
		
		// LIST ALL
		ps = new ProductServiceImpl();
		
		products = ps.list();
		
		for (Product p : products) {
			System.out.println(p);
		}
		
		// ADD PRODUCT
		/*product = new Product("Pizza barbacoa", "De calidad", VAT.GENERAL, 12.86, 47, CAT.ALIMENTACION);
		ps.create(product);*/
		
		// SEARCH
		/*ps = new ProductServiceImpl();
		
		product = new Product("Pizza barbacoa", null, null, null, null, null);
		
		products = ps.search(product);
		
		for (Product p : products) {
			System.out.println(p);
		}*/
		
		
		
	}

}
