package com.tdtu.ex02;

public class Product {
	private String id;
	private String name;
	private String description;

	public Product() {
	}

	public Product(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='" + description + '\''
				+ '}';
	}
}
