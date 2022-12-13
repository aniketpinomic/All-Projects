package com.example1.API.ManagementEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column
	@Size(max=5,min=2,message="Max Length is 5")
	private int productNum;
	
	@NotNull
	@Column
	@Pattern(regexp="([A-Za-z]{15})",message="Name of product not in number")
	private String productName;
	
	@Column
	private int productQTY;
	
	@NotNull
	@Column
	@Max(value=5)
	private int productPrise;


	public Product() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQTY() {
		return productQTY;
	}
	public void setProductQTY(int productQTY) {
		this.productQTY = productQTY;
	}
	public int getProductPrise() {
		return productPrise;
	}
	public void setProductPrise(int productPrise) {
		this.productPrise = productPrise;
	}


}
