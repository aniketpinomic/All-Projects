package com.example1.API.ManagementRepository;

import com.example1.API.ManagementEntity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
