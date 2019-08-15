package com.en.ws.repositories;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.en.ws.entities.Product;
import com.en.ws.enums.CAT;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductRepositoryImpl implements ProductRepository {
	
	// GSON
	private final String FileName = "warehouse.json";
	private Gson gson;

	// Load GSON
	public ProductRepositoryImpl() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	// Create one new product
	public boolean create(Product product) {
		
		if (product == null) {
			return false;
		}
		
		List<Product> allProducts = new ArrayList<Product>(readAll());
		allProducts.add(product);
		saveJson(allProducts);
		
		return true;
		
	}
	
	// List all products
	public List<Product> list() {

		List<Product> allProducts = new ArrayList<Product>(readAll());
		
		return allProducts;
		
	}
	
	// Search product
	public List<Product> search(Product filter) {

		List<Product> allProducts = new ArrayList<Product>(readAll());
		List<Product> filteredProducts = new ArrayList<Product>();
		
		for (Product product : allProducts) {
			
			// Code
			if (filter.getCode() != null && product.getCode().equals(filter.getCode())) {
				filteredProducts.add(product);
			}
			
			// Name
			else if (filter.getName() != null && product.getName().equals(filter.getName())) {
				filteredProducts.add(product);
			}
			
			// Category
			else if (filter.getCategory() != null && product.getCategory().equals(filter.getCategory())) {
				filteredProducts.add(product);
			}
		}
		
		return filteredProducts;
	}

	public boolean modify(Integer code, Product editedProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Integer code) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sell(Integer code, Integer num) {
		// TODO Auto-generated method stub
		return false;
	}

	public void infoSells() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Read all data in Json file
	 * @return List with all products in Json file
	 */
	public List<Product> readAll() {
		
		String lines = "";
		String line = "";
		
		try {
			
			FileReader fr = new FileReader(FileName);
			BufferedReader br = new BufferedReader(fr);
			
			while (null != (line = br.readLine())) {
				lines = lines.concat(line);
			}
			
			fr.close();
			br.close();
			
		} catch (FileNotFoundException e) {
			
			System.err.println("No se ha podido encontrar el archivo '"+FileName+"'");
			
		} catch (IOException e) {

			System.err.println("Se ha producido un error al leer el archivo");
			
		}
		
		Product[] productsArray = gson.fromJson(lines, Product[].class);
		List<Product> allProducts = new ArrayList<Product>();
		
		if(productsArray != null)
		{
			allProducts = Arrays.asList(productsArray);
		}
		
		return allProducts;
		
	}
	
	/**
	 * Save data to Json file
	 * @param finalProducts
	 */
	private void saveJson(List<Product> finalProducts) {
		
		FileWriter fw;
		
		try {
			
			fw = new FileWriter(FileName, false);
			fw.write(gson.toJson(finalProducts));
			fw.close();
			
		} catch (IOException e) {
			
			System.err.println("Se ha producido un error al guardar los datos.");
			
		}
		
	}
	
}
