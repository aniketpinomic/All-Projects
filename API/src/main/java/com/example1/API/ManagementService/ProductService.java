package com.example1.API.ManagementService;

import java.util.List;

import com.example1.API.ManagementEntity.Product;

public interface ProductService {

	Product insertProduct(Product obj);
	List<Product> getAllProducts();
	Product getProductByID(int id);
	Product updateProduct(Product newProduct);
	void deleteProduct(int id);
}
