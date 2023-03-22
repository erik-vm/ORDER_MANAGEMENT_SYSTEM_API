package vm.erik.order_management_system_api.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vm.erik.order_management_system_api.dto.CustomerDTO;
import vm.erik.order_management_system_api.dto.ProductDTO;
import vm.erik.order_management_system_api.service.CustomerService;
import vm.erik.order_management_system_api.service.ProductService;

@Component
public class Runner implements CommandLineRunner {

    private final CustomerService customerService;
    private final ProductService productService;

    public Runner(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        createCustomers();
        createProducts();
    }

    private void createCustomers() {
        CustomerDTO johnDoe = new CustomerDTO();
        johnDoe.setRegistrationCode("JD_001");
        johnDoe.setFullName("John Doe");
        johnDoe.setEmail("john.doe@mail.com");
        johnDoe.setTelephone("56556677");
        customerService.saveCustomer(johnDoe);

        CustomerDTO maryJane = new CustomerDTO();
        maryJane.setRegistrationCode("MJ_001");
        maryJane.setFullName("Mary Jane");
        maryJane.setEmail("mary.jane@mail.com");
        maryJane.setTelephone("9911177");
        customerService.saveCustomer(maryJane);

        CustomerDTO phoebeBuffet = new CustomerDTO();
        phoebeBuffet.setRegistrationCode("PB_001");
        phoebeBuffet.setFullName("Phoebe Buffet");
        phoebeBuffet.setEmail("phoebe.buffet@mail.com");
        phoebeBuffet.setTelephone("111222333");
        customerService.saveCustomer(phoebeBuffet);

    }

    private void createProducts() {
        ProductDTO socks = new ProductDTO();
        socks.setProductName("Socks");
        socks.setSkuCode("SKS001");
        socks.setUnitPrice(1.59d);
        productService.saveProduct(socks);

        ProductDTO sunglasses = new ProductDTO();
        sunglasses.setProductName("Sunglasses");
        sunglasses.setSkuCode("SNG123");
        sunglasses.setUnitPrice(15.9d);
        productService.saveProduct(sunglasses);

        ProductDTO hat = new ProductDTO();
        hat.setProductName("Hat");
        hat.setSkuCode("HT897");
        hat.setUnitPrice(19.9d);
        productService.saveProduct(hat);
    }

}
