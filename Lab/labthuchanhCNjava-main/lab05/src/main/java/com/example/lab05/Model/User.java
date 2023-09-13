package com.example.lab05.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name= "User")
public class User {
    @Id
    @Column(name = "username", unique = true, nullable = false)
    public String username;
    public String password;
    public String email;
    public User(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
