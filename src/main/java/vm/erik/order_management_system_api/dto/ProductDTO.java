package vm.erik.order_management_system_api.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String productName;
    private String skuCode;
    private double unitPrice;
}
