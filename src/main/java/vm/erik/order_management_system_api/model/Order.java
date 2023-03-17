package vm.erik.order_management_system_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_order", joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products = new HashSet<>();
}