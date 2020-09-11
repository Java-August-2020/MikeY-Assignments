package com.mike.prodscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.prodscategories.models.Category;
import com.mike.prodscategories.models.Product;
import com.mike.prodscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository cRepo;
	
	//find all 
	public List<Category> allCategories() {
		return this.cRepo.findAll();
	}
	
	//find by id
	public Category getCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	//create Category
	public Category createNew(Category newCategory) {
		return this.cRepo.save(newCategory);
	}
	
	//find categories not in products
	public List<Category> findCategoryNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	
	// Add Product to a category
			public void addProdToCategory(Product product, Category category) {
				// get the List of products  from the category model
				List<Product> products = category.getProducts();
				//add the category to the product
				products.add(product);
				// Update the DB
				this.cRepo.save(category);
			}
}
