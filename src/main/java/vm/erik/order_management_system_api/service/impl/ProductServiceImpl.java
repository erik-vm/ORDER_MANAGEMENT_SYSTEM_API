package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.dto.ProductDTO;
import vm.erik.order_management_system_api.mapper.ProductMapper;
import vm.erik.order_management_system_api.model.Product;
import vm.erik.order_management_system_api.repository.ProductRepository;
import vm.erik.order_management_system_api.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ProductDTO saveProduct(ProductDTO product) {
        Product productFromProductDTO = productMapper.fromProductDTOToProduct(product);
        productRepository.save(productFromProductDTO);
        return productMapper.fromProductToProductDTO(productFromProductDTO);
    }

    @Override
    public ProductDTO findByName(String name) {
        return productMapper.fromProductToProductDTO(productRepository.findByProductName(name));
    }

}
