package com.en.ws.services;

import java.util.List;

import com.en.ws.entities.Product;
import com.en.ws.repositories.ProductRepository;
import com.en.ws.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRep;
	
	// Constructor
	public ProductServiceImpl() {
		productRep = new ProductRepositoryImpl();
	}

	// Services
	public boolean create(Product product) {
		return productRep.create(product);
	}

	public List<Product> list() {
		return productRep.list();
	}

	public List<Product> search(Product filter) {
		return productRep.search(filter);
	}

	public boolean modify(Integer code, Product editedProduct) {
		return productRep.modify(code, editedProduct);
	}

	public boolean delete(Integer code) {
		return productRep.delete(code);
	}

	public boolean sell(Integer code, Integer num) {
		return productRep.sell(code, num);
	}

	public void infoSells() {
		// TODO show sells info
	}

}
