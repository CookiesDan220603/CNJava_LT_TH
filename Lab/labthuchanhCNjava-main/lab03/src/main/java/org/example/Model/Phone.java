package org.example.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "MobilePhone")
public class Phone {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    public String id;
    @Column(name = "name")
    public String name;
    @Column(name = "color")
    public String color;
    @Column(name = "country")
    public String country;
    @Column(name = "price")
    public int price;
    @Column(name = "quantity")
    public int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manu_id")
    public Manufacture manufactures;
    public Phone(){
        super();
    }
    public Phone(String id, String name, String color, String country, int price, int quantity, Manufacture manufactures) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.country = country;
        this.price = price;
        this.quantity = quantity;
        this.manufactures = manufactures;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufactures=" + manufactures.name +
                '}';
    }
}
