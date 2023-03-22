package vm.erik.order_management_system_api.model;

import ch.ascendise.Validator.Annotations.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID customerId;
    @Column(name = "registration_code", nullable = false)
    private String registrationCode;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String telephone;
    @OneToMany(mappedBy = "customer")
    List<OrderLine> orderLines = new ArrayList<>();
}
