package vm.erik.order_management_system_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {

    private UUID productId;
    private String productName;
    private String skuCode;
    private double unitPrice;
}
