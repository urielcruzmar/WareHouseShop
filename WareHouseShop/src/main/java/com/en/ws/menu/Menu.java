package com.en.ws.menu;

import java.util.Scanner;

import com.en.ws.entities.Product;
import com.en.ws.enums.CAT;
import com.en.ws.enums.VAT;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * Main menu options
	 * @return option
	 */
	public static Integer MainMenu() {
		
		Integer option = -1;
		
		System.out.println("PRODUCTATOR V.1.0\n"
				+ "1 Nuevo Producto\n"
				+ "2 Listado de Productos\n"
				+ "3 Buscar Producto\n"
				+ "4 Modificar Producto\n"
				+ "5 Eliminar Producto\n"
				+ "6 Vender Producto\n"
				+ "7 Super Informe Ejecutivo\n"
				+ "0 Salir\n"
				+ "Acción:");
		
		while (option == -1) {
			try {
				option = Integer.parseInt(scan.nextLine());
				if (option < 0 || option > 7) {
					Exception r = new RuntimeException("Out of range");
			        throw new RuntimeException("Invalid option", r);
				}
			} catch (Exception e) {
				System.err.println("Introduce una opción válida:");
				option = -1;
			}
		}
		
		return option;
		
	}
	
	/**
	 * Ask the user the properties of the product to be created
	 * @return product
	 */
	public static Product addProductMenu() {

		String name = "unknown";
		String description = "unknown";
		VAT vat = null;
		Double price = 0.0;
		Integer stock = 0;
		CAT category = null;

		// Name
		System.out.print("Nombre del producto: ");
		name = scan.nextLine();
		
		// Description
		System.out.print("Descripción del producto: ");
		description = scan.nextLine();
		
		// VAT
		while (vat == null) {
			System.out.println("IVA:\n"
					+ "1 GENERAL\n"
					+ "2 REDUCIDO\n"
					+ "3 SUPERREDUCIDO");
			try {
				switch (Integer.parseInt(scan.nextLine())) {
					case 1:
						vat = VAT.GENERAL;
						break;
						
					case 2:
						vat = VAT.REDUCTED;
						break;
						
					case 3:
						vat = VAT.SUPERREDUCTED;
						break;
						
					default:
						vat = null;
						break;
				}
			} catch (Exception e) {
				System.err.println("IVA inválido");
			}
		}
		
		// Price
		while(price <= 0.0) {
			System.out.print("Precio del producto (Debe ser mayor que 0€): ");
			try {
				price = Double.parseDouble(scan.nextLine());
				if (price < 0.0) {
					Exception r = new RuntimeException("Out of range");
			        throw new RuntimeException("Invalid option", r);
				}
			} catch (Exception e) {
				System.err.println("Precio inválido");
				price = 0.0;
			}
		}
		
		// Stock
		while(stock <= 0) {
			System.out.print("Stock (0 por defecto): ");
			try {
				stock = Integer.parseInt(scan.nextLine());
				if (stock < 0) {
					Exception r = new RuntimeException("Out of range");
			        throw new RuntimeException("Invalid option", r);
				}
			} catch (Exception e) {
				System.err.println("Stock inválido");
				stock = 0;
			}
		}
		
		// Category
		category = askForCategory();

		Product product = new Product(null, name, description, vat, price, stock, category);

		return product;
		
	}
	
	/**
	 * Ask for the user the product to search
	 * @return product
	 */
	public static Product searchProductMenu() {
		
		Product product = null;
		
		System.out.println("Puedes buscar por:\n"
				+ "1 Codigo\n"
				+ "2 Nombre\n"
				+ "3 Categoria");

		try {
			switch (Integer.parseInt(scan.nextLine())) {
			
				// Code
				case 1:
					System.out.println("Introduce el codigo:");
					product = new Product(Integer.parseInt(scan.nextLine()), null, null, null, null, null, null);
					break;
				
				// Name
				case 2:
					System.out.println("Introduce el nombre:");
					product = new Product(null, scan.nextLine(), null, null, null, null, null);
					break;
				
				// Category
				case 3:
					System.out.println("Introduce la categoria:");
					product = new Product(null, null, null, null, null, null, askForCategory());
					break;
					
			}
		} catch (Exception e) {
			System.err.println("Se ha producido un error");
		}
		
		return product;
	}
	
	/**
	 * Ask the user for the category
	 * @return product category
	 */
	private static CAT askForCategory() {
	
		CAT category = null;
		while (category == null) {
			System.out.println("Categoría:\n"
					+ "1 ALIMENTACION\n"
					+ "2 MATERIAL\n"
					+ "3 MECANICO\n"
					+ "4 LUJO");
			try {
				switch (Integer.parseInt(scan.nextLine())) {
					case 1:
						category = CAT.ALIMENTACION;
						break;
						
					case 2:
						category = CAT.MATERIAL;
						break;
						
					case 3:
						category = CAT.MECANICO;
						break;
						
					case 4:
						category = CAT.LUJO;
						break;
						
					default:
						category = null;
						break;
				}
			} catch (Exception e) {
				System.err.println("Categoría inválida");
			}
		}
		return category;
	}
	
}
