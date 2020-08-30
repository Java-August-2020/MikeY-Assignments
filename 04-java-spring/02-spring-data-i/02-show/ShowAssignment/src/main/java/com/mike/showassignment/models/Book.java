package com.mike.showassignment.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank // it requires a constrained string is valid as long as its not null and the trimmed length is greater than 0
	@Size(min=1, max=20)
	@NotBlank
	private String title;
	@Size(min=3, max=100)
	private String description;
	private String language;
	private Integer pages;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy--MM-DD HH:-mm:--:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy--MM-DD HH:-mm:--:ss")
	private Date updatedAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// POJO
	public Book() {
		
	}
	
	//overloaded method

	public Book(@NotBlank @Size(min = 1, max = 20) @NotBlank String title, @Size(min = 3, max = 20) String description,
			String language, Integer pages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.pages = pages;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
