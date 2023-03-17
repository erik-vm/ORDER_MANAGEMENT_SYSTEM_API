package vm.erik.order_management_system_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id", nullable = false)
    private UUID customerId;
    @Column(name = "registration_code", nullable = false)
    private String registrationCode;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telephone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();
}
