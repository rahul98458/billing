package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	boolean addProduct(Product p);
	boolean updateProduct(Product p);
	List<Product> getAllProduct();
	boolean addQuantity(Product p);

}
