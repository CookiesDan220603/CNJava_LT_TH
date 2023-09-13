package com.example.lab05.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Product")
public class Product {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;
    public String name;
    public String color;
    public int prices;

    public Product(int id, String name, String color, int prices) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.prices = prices;
    }
    public Product(String name, String color, int prices) {
        this.name = name;
        this.color = color;
        this.prices = prices;
    }

    public Product(String name, int prices) {
        this.name = name;
        this.prices = prices;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", prices=" + prices +
                '}';
    }
}
