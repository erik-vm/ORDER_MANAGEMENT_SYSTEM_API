package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.ProductDTO;

public interface ProductService {

    public ProductDTO saveProduct(ProductDTO product);

    public ProductDTO findByName(String name);
}
