package com.mike.prodscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.prodscategories.models.Category;
import com.mike.prodscategories.models.Product;
import com.mike.prodscategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pRepo;
	
	//find all products
	public List<Product> allProducts() {
		return this.pRepo.findAll();
	}
	
	//find product by id
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//create Product
	public Product createNew(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	//find products not in categories
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
	
	// Add Category to a product
		public void addCategoryToProduct(Category category, Product product) {
			// get the List of categories from the product model
			List<Category> categories = product.getCategories();
			//add the category to the product
			categories.add(category);
			// Update the DB
			this.pRepo.save(product);
		}
}
