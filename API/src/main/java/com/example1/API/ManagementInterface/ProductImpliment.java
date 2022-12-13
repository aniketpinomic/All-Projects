package com.example1.API.ManagementInterface;

import java.util.List;
import com.example1.API.ManagementEntity.Product;
import com.example1.API.ManagementRepository.ProductRepository;
import com.example1.API.ManagementService.ProductService;

import org.springframework.stereotype.Service;

@Service
public class ProductImpliment implements ProductService {

	private ProductRepository ProdRepo;

	public ProductImpliment(ProductRepository ProdRepo) {
		this.ProdRepo = ProdRepo;
	}

	public List<Product> getAllProducts() {
		return ProdRepo.findAll();
	}

	public Product insertProduct(Product obj) {
		return ProdRepo.save(obj);
	}

	public Product getProductByID(int id) {
		return ProdRepo.findById(id).get();
	}

	public Product updateProduct(Product newProduct) {
		return ProdRepo.save(newProduct);
	}

	public void deleteProduct(int id) {
		ProdRepo.deleteById(id);
		}

}
