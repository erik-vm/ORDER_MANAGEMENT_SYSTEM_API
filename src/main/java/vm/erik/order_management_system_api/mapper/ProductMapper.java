package vm.erik.order_management_system_api.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.order_management_system_api.dto.ProductDTO;
import vm.erik.order_management_system_api.model.Product;

@Service
public class ProductMapper {


    public ProductDTO fromProductToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public Product fromProductDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }
}
