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
		
		Boolean result = false;
		Integer lastCode = 0;
		Product lastProduct = null;
		
		if (product != null) {
			
			List<Product> allProducts = new ArrayList<Product>(readAll());
			
			// Check if Product is not in the list
			if (search(new Product(null, product.getName(), null, null, null, null, null)).isEmpty()) {
				
				if (!allProducts.isEmpty()) {
					lastProduct = allProducts.get(allProducts.size()-1);
					lastCode = lastProduct.getCode();
				}
				product.setCode(lastCode+1);
				
				allProducts.add(product);
				saveJson(allProducts);
				result = true;
				
			}
			
		}
		
		return result;
		
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

	// Modify product
	public boolean modify(Integer code, Product editedProduct) {
		
		Boolean result = false;
		List<Product> allProducts = new ArrayList<Product>(readAll());
		
		Integer productPositionCode = getProductPosition(allProducts, code);
		
		/*for (Product product : allProducts) {
			
			if (code != null && product.getCode().equals(code)) {
				break;
			}
			productPositionCode++;
			
		}*/
		
		if (productPositionCode != 0 && code <= allProducts.size()) {
			allProducts.get(productPositionCode).setName(editedProduct.getName());
			saveJson(allProducts);
			result = true;
		}
		
		return result;
		
	}

	// Delete product
	public boolean delete(Integer code) {
		
		Boolean result = false;
		List<Product> allProducts = new ArrayList<Product>(readAll());
		Product productToDelete = null;
		
		for (Product product : allProducts) {
			
			if (code != null && product.getCode().equals(code)) {
				productToDelete = product;
			}
			
		}
		
		if (productToDelete != null) {
			allProducts.remove(productToDelete);
			saveJson(allProducts);
			result = true;
		}
		
		return result;
		
	}

	// Add sold items to product
	public boolean sell(Integer code, Integer num) {
		
		Boolean result = false;
		List<Product> allProducts = new ArrayList<Product>(readAll());
		Integer productPositionCode = getProductPosition(allProducts, code);
		
		Integer currentStock = allProducts.get(productPositionCode).getStock();
		Integer currentSells = allProducts.get(productPositionCode).getTotalSells();
		
		if (allProducts.get(productPositionCode).getStock() >= num) {
			allProducts.get(productPositionCode).setStock(currentStock-num);
			allProducts.get(productPositionCode).setTotalSells(currentSells+num);
			saveJson(allProducts);
			result = true;
		}

		return result;
		
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
	
	/**
	 * Get the position of the product in the list
	 * @param allProducts
	 * @param code
	 * @return product position
	 */
	private Integer getProductPosition(List<Product> allProducts, Integer code) {
		
		Integer productPositionCode = 0;
		
		for (Product product : allProducts) {
			
			if (code != null && product.getCode().equals(code)) {
				break;
			}
			productPositionCode++;
			
		}
		
		return productPositionCode;
	}
	
}
