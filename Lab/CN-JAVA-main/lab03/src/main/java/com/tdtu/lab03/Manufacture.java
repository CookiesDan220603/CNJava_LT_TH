package com.tdtu.lab03;

import javax.persistence.*;

import jakarta.validation.constraints.Size;

@Entity
@Table(name = "manufactures")
public class Manufacture {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@Size(min = 3, max = 128)
    private String name;
	
	@Column(name = "location")
    private String location;
	
	@Column(name = "employee")
    private int employee;
	
	
    public Manufacture() {
		// TODO Auto-generated constructor stub
	}
	public Manufacture(int id, String name, String location, int employee) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.employee = employee;
	}
	
	public Manufacture(String name, String location, int employee) {
		this.name = name;
		this.location = location;
		this.employee = employee;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Manufacture [id=" + id + ", name=" + name + ", location=" + location + ", employee=" + employee + "]";
	}
    
}
