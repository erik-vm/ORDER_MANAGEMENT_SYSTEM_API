package vm.erik.order_management_system_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderLineDTO {

    private LocalDateTime dateOfSubmission;
    private CustomerDTO customer;
}
