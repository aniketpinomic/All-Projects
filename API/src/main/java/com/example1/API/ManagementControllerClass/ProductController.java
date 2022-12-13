package com.example1.API.ManagementControllerClass;

import com.example1.API.AdminDetails.AdminDetailsClass;
import com.example1.API.ManagementEntity.Product;
import com.example1.API.ManagementService.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	ProductService prodServ;

	public ProductController(ProductService prodServ) {
		this.prodServ = prodServ;
	}

	@GetMapping("/viewAllProduct")
	public String viewAllProducts (Model model) {
		model.addAttribute("productList",prodServ.getAllProducts());
		return "firstPage";
	}

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		Product pro = new Product();
		model.addAttribute("productDetails", pro);
		return "createProduct";
	}

	@GetMapping("/product/edit/{id}")
	public String editProduct(@PathVariable int id, Model model) {
		model.addAttribute("productFromDb",prodServ.getProductByID(id) );
		return "viewSingleProduct";
	}

	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable int id,@ModelAttribute("productFromDb") Product newProductFromFrontEnd, Model model) {
		Product existingObj = prodServ.getProductByID(id);

		existingObj.setId(id);
		existingObj.setProductNum(newProductFromFrontEnd.getProductNum());
		existingObj.setProductName(newProductFromFrontEnd.getProductName());
		existingObj.setProductQTY(newProductFromFrontEnd.getProductQTY());
		existingObj.setProductPrise(newProductFromFrontEnd.getProductPrise());
		prodServ.updateProduct(existingObj);
		return "redirect:/viewAllProduct";
	}

	@PostMapping("/viewAllProduct")
	public String saveProduct(@ModelAttribute("productDetails")Product productDetails) {
		prodServ.insertProduct(productDetails);
		return "redirect:/viewAllProduct";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		prodServ.deleteProduct(id);
		return "redirect:/viewAllProduct";

	}
	
	@GetMapping("/logoutFromApp")
	public String logoutFromApplication(Model model) {
		return "logout";
	}

	@GetMapping("/login")
	public String loginToApplication(Model model) {
		AdminDetailsClass admin=new AdminDetailsClass();
		model.addAttribute("adminObj", admin);
		return "login";
	}

	@GetMapping("/validatingData")
	public String validationOfLoginCredentials(@ModelAttribute("adminObj") AdminDetailsClass adminData) {
		if(adminData.getUsername().equals("Aniket") && adminData.getPassword().equals("Aniket1234")) {
			return "redirect:/viewAllProduct";
		}
		else {
			return "redirect:/login";	
		}
		
	}


}
