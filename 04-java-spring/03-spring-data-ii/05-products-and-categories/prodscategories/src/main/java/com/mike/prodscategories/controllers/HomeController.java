package com.mike.prodscategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mike.prodscategories.models.Category;
import com.mike.prodscategories.models.Product;
import com.mike.prodscategories.services.CategoryService;
import com.mike.prodscategories.services.ProductService;


@Controller
public class HomeController {

	@Autowired
	ProductService pService;
	@Autowired
	CategoryService cService;
	
	//display all Products
		@RequestMapping("/")
		public String allProducts(Model viewModel) {
			viewModel.addAttribute("products", pService.allProducts());
			return "products/index.jsp";
		}
		
		@RequestMapping("/categories")
		public String allCats(Model viewModel) {
			viewModel.addAttribute("categories", cService.allCategories());
			return "/categories/index.jsp";
		}
			
		//create new products page
		@RequestMapping("/products/new")
		public String newDisplay(@ModelAttribute("products") Product newProduct) {
			return "/products/new.jsp";
		}
		
		//create new Product
		@PostMapping("/products")
		public String createNew(@Valid @ModelAttribute("products") Product newProduct, BindingResult result, Model viewModel) {
			if (result.hasErrors()) {
				viewModel.addAttribute("products", pService.allProducts());
				return "/products/new.jsp";
			} else {
				this.pService.createNew(newProduct);
				//  
				return "redirect:/";
			}
		}

		//create new categories page
		@RequestMapping("/categories/new")
		public String newDisplay(@ModelAttribute("categories") Category newCategory) {
			return "/categories/new.jsp";
		}
		
		
		//product Show 
		@RequestMapping("/products/{id}")
		public String productShow(@PathVariable("id")Long id, Model viewModel) {	
			viewModel.addAttribute("allCategories", cService.allCategories());
			viewModel.addAttribute("product", pService.getProduct(id));
			Product oneProduct = this.pService.getProduct(id);
			viewModel.addAttribute("categories", cService.findCategoryNotInProduct(oneProduct));
			return "products/show.jsp";
		}
		
		//add a category to the product
		@PostMapping("/products/{id}")
		public String addCategoryToProducts(@RequestParam("addCatToProd") Long catId, @PathVariable("id") Long id) {
			Product oneProduct = this.pService.getProduct(id);
			Category cats = this.cService.getCategory(catId);
			this.pService.addCategoryToProduct(cats, oneProduct);
			return "redirect:/";
			
		}
		
		//show for category
		@RequestMapping("/categories/{id}")
		public String showcat(@PathVariable("id") Long id, Model viewModel) {
			viewModel.addAttribute("allProducts", pService.allProducts());
			viewModel.addAttribute("category", cService.getCategory(id));
			Category oneCategory =  this.cService.getCategory(id);
			viewModel.addAttribute("products", pService.findProductsNotInCategory(oneCategory));
			return "categories/show.jsp";
		}
		
		
		//add a product to a category 
		@PostMapping("/categories/{id}")
		public String addProductToCategory(@RequestParam("addProdToCat") Long prodId, @PathVariable("id") Long id) {
			Category oneCategory =  this.cService.getCategory(id);
			Product prods = this.pService.getProduct(prodId);
			this.cService.addProdToCategory(prods, oneCategory);
			return "redirect:/";
		}
		
		
		//create a new Category
		@PostMapping("/categories")
		public String createNew(@Valid @ModelAttribute("categories") Category newCategory, BindingResult result, Model viewModel) {
			if (result.hasErrors()) {
				viewModel.addAttribute("categories", cService.allCategories());
				return "/categories/new.jsp";
			} else {
				this.cService.createNew(newCategory);
				// redirect back to /categories/show 
				return "redirect:/categories";
			}
		}
}
