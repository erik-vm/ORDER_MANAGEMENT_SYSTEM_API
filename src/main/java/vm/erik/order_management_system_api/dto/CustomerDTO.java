package vm.erik.order_management_system_api.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String registrationCode;
    private String fullName;
    private String email;
    private String telephone;
}
