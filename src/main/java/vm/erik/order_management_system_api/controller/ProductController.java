package vm.erik.order_management_system_api.controller;

import org.springframework.web.bind.annotation.*;
import vm.erik.order_management_system_api.dto.ProductDTO;
import vm.erik.order_management_system_api.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{name}")
    public ProductDTO findByName(@PathVariable("name") String name) {
        return productService.findByName(name);
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(product);
    }
}
