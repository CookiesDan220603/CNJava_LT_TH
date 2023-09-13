package org.example;
public class Product {
    public int id;
    public String name, description;
    public float price;
    public Product(int id, String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public Product() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
    }

    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

}
