package vm.erik.order_management_system_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerDTO {

    private UUID customerId;
    private String registrationCode;
    private String fullName;
    private String email;
    private String telephone;
}
