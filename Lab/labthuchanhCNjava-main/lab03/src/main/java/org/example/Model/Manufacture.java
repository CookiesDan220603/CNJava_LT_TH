package org.example.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name= "manufacture")
public class Manufacture {
    @Id
    @Column(name = "manu_id", unique = true, nullable = false)
    public String id;
    @Column(name = "employee")
    public int employee;

    @Column(name = "name")
    public String name;
    @Column(name = "location")
    public String location;
    @OneToMany(mappedBy = "manufactures", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    public List<Phone> phones;
    public Manufacture(){
        super();
    }
    public Manufacture(String id, int employee, String name, String location) {
        this.id = id;
        this.employee = employee;
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "id='" + id + '\'' +
                ", employee=" + employee +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
