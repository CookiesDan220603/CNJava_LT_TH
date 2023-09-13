package org.example;

public class Product {
    public String name, color;
    public float price;
    public int id;

    public Product(int id,String name, String color, float price) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.id = id;
    }

    public Product(String name, String color, float price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }
    public Product() {
        this.id = 0;
        this.name = "";
        this.color = "";
        this.price = 0;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
