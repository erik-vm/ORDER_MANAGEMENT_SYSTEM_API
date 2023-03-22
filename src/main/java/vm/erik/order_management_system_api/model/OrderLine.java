package vm.erik.order_management_system_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders_lines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="order_line_id", nullable = false)
    private UUID orderLineId;
    @Column(name = "date_of_submission", nullable = false)
    private LocalDateTime dateOfSubmission;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;
    @ManyToMany
    @JoinTable(name = "order_line_orders", joinColumns = {@JoinColumn(name = "order_line_id")}, inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> orders = new ArrayList<>();

    public void addOrderToOrderLine(Order order){
        this.orders.add(order);
    }
}
