package tdtu.edu.springecommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Order> orders;

    public Customer(Long customerId, String name, String phone, String address) {
        this.id = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    public boolean containNone(){
        return Objects.equals(this.name, "")
                || Objects.equals(this.address, "")
                || Objects.equals(this.phone, "")
                || Objects.equals(this.email, "");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
