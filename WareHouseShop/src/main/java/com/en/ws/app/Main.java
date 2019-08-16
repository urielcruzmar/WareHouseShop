package com.en.ws.app;

import java.util.List;

import com.en.ws.entities.Product;
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
		
		ProductService ps = new ProductServiceImpl();
		List<Product> products;
		Integer option;
		
		// Main menu selection
		while ((option = Menu.MainMenu()) != 0) {
			
			switch (option) {
				
				// Create
				case 1:
					if (ps.create(Menu.addProductMenu())) {
						System.out.println("Producto creado");
					}
					break;
					
				// List
				case 2:
					products = ps.list();
					for (Product p : products) {
						System.out.println(p);
					}
					break;
					
				// Search
				case 3:
					products = ps.search(Menu.searchProductMenu());
					for (Product p : products) {
						System.out.println(p);
					}
					break;
				
				// Modify
				case 4:
					if (ps.modify(Menu.askForCode(), Menu.addProductMenu())) {
						System.out.println("Producto modificado");
					} else {
						System.err.println("No se ha modificado el producto");
					}
					break;
					
				// Delete
				case 5:
					if (ps.delete(Menu.askForCode())) {
						System.out.println("Producto eliminado");
					} else {
						System.err.println("No se ha eliminado el producto");
					}
					break;
					
				// Sell
				case 6:
					if (ps.sell(Menu.askForCode(), Menu.askForSells())) {
						System.out.println("Ventas añadidas");
					} else {
						System.err.println("Se ha producido un error al añadir las ventas\n"
								+ "Comprueba que el stock sea suficiente");
					}
					break;
				
				// Summary
				case 7:
					System.out.println("EN DESARROLLO");
					break;
					
			}
			
		}
		
		
		// Variables
		/*Product product = null;
		ProductService ps;
		List<Product> products;*/
		
		// LIST ALL
		/*ps = new ProductServiceImpl();
		
		products = ps.list();
		
		for (Product p : products) {
			System.out.println(p);
		}*/
		
		// ADD PRODUCT
		/*product = new Product(null, "Pizza barbacoa PREMIUM", "De calidad", VAT.GENERAL, 12.86, 47, CAT.ALIMENTACION);
		if (ps.create(product)) {
			System.out.println("NICE");
		}
		else {
			System.out.println("NOPE");
		}*/
		
		// SEARCH
		/*ps = new ProductServiceImpl();
		
		product = new Product("Pizza barbacoa", null, null, null, null, null);
		
		products = ps.search(product);
		
		for (Product p : products) {
			System.out.println(p);
		}*/
		
		// MODIFY
		/*boolean result = ps.modify(5, new Product(null, "Pizza barbacoa ULTRA PREMIUM", "De calidad", VAT.GENERAL, 12.86, 47, CAT.ALIMENTACION));
		if (result) {
			System.out.println("NICEU");
		}*/
		
		// DELETE
		/*if (ps.delete(3)) {
			System.out.println("DELETED");
		}*/
		
		// SELL
		/*if (ps.sell(2, 30)) {	
			System.out.println("MONEY");
		}*/
		
	}

}
