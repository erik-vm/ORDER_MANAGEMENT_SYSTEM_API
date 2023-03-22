package vm.erik.order_management_system_api.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private ProductDTO product;
    private int quantity;
}
