package vm.erik.order_management_system_api.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vm.erik.order_management_system_api.model.Customer;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.model.Product;
import vm.erik.order_management_system_api.service.CustomerService;
import vm.erik.order_management_system_api.service.OrderService;
import vm.erik.order_management_system_api.service.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    public Runner(CustomerService customerService, ProductService productService, OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }


    @Override
    public void run(String... args) throws Exception {
        createCustomers();
        createProducts();
        createOrders();
    }

    private void createCustomers() {
        Customer johnDoe = new Customer();
        johnDoe.setRegistrationCode("JD_001");
        johnDoe.setFullName("John Doe");
        johnDoe.setEmail("john.doe@mail.com");
        johnDoe.setTelephone("56556677");
        customerService.saveCustomer(johnDoe);

        Customer maryJane = new Customer();
        maryJane.setRegistrationCode("MJ_001");
        maryJane.setFullName("Mary Jane");
        maryJane.setEmail("mary.jane@mail.com");
        maryJane.setTelephone("9911177");
        customerService.saveCustomer(maryJane);

        Customer phoebeBuffet = new Customer();
        phoebeBuffet.setRegistrationCode("PB_001");
        phoebeBuffet.setFullName("Phoebe Buffet");
        phoebeBuffet.setEmail("phoebe.buffet@mail.com");
        phoebeBuffet.setTelephone("111222333");
        customerService.saveCustomer(phoebeBuffet);

    }

    private void createProducts() {
        Product socks = new Product();
        socks.setProductName("Socks");
        socks.setSkuCode("SKS001");
        socks.setUnitPrice(1.59d);
        productService.saveProduct(socks);

        Product sunglasses = new Product();
        sunglasses.setProductName("Sunglasses");
        sunglasses.setSkuCode("SNG123");
        sunglasses.setUnitPrice(15.9d);
        productService.saveProduct(sunglasses);

        Product hat = new Product();
        hat.setProductName("Hat");
        hat.setSkuCode("HT897");
        hat.setUnitPrice(19.9d);
        productService.saveProduct(hat);
    }

    private void createOrders() {
        Customer johnDoe = customerService.findByEmail("john.doe@mail.com");
        Customer maryJane = customerService.findByEmail("mary.jane@mail.com");
        Customer phoebeBuffet = customerService.findByEmail("phoebe.buffet@mail.com");
        Product socks = productService.findByName("Socks");
        Product sunglasses = productService.findByName("Sunglasses");
        Product hat = productService.findByName("Hat");

        Order order1 = new Order();
        order1.setCustomer(johnDoe);
        List<Product> order1Products = new ArrayList<>(List.of(socks, sunglasses, hat));
        order1.setProducts(order1Products);
        order1.setDateOfSubmission(LocalDate.now());
        orderService.saveOrder(order1);

        Order order2 = new Order();
        order2.setCustomer(maryJane);
        List<Product> order2Products = new ArrayList<>(List.of(socks, sunglasses, sunglasses));
        order2.setProducts(order2Products);
        order2.setDateOfSubmission(LocalDate.now());
        orderService.saveOrder(order2);

        Order order3 = new Order();
        order3.setCustomer(phoebeBuffet);
        List<Product> order3Products = new ArrayList<>(List.of(hat, hat, hat));
        order3.setProducts(order3Products);
        order3.setDateOfSubmission(LocalDate.now());
        orderService.saveOrder(order3);

        Order order4 = new Order();
        order4.setCustomer(maryJane);
        List<Product> order4Products = new ArrayList<>(List.of(socks, socks, sunglasses));
        order4.setProducts(order4Products);
        order4.setDateOfSubmission(LocalDate.now());
        orderService.saveOrder(order4);
    }
}
