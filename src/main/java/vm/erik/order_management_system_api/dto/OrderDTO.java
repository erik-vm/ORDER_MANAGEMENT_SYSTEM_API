package vm.erik.order_management_system_api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDTO {

    private UUID orderId;
    private LocalDate dateOfSubmission;
    private CustomerDTO customer;
}
