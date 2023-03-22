package vm.erik.order_management_system_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private int quantity;
}
