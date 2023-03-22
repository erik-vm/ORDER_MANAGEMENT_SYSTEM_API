package vm.erik.order_management_system_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vm.erik.order_management_system_api.dto.ProductDTO;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService underTest;

    ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO();
        productDTO.setSkuCode("TEST-PROD");
        productDTO.setProductName("TEST-PROD");
        productDTO.setUnitPrice(12.34);
    }

    @Test
    void saveProduct() {
        //given
        ProductDTO savedProduct = underTest.saveProduct(productDTO);

        //when
        boolean saveSuccessful = savedProduct != null;

        //then
        assertTrue(saveSuccessful);
    }

    @Test
    void findByName() {
        //given
        underTest.saveProduct(productDTO);

        //when
        boolean saveSuccessful = underTest.findByName("TEST-PROD").equals(productDTO);

        //then
        assertTrue(saveSuccessful);
    }
}
