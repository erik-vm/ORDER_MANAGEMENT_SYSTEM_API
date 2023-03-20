package vm.erik.order_management_system_api.controller;


import org.springframework.web.bind.annotation.*;
import vm.erik.order_management_system_api.dto.CustomerDTO;
import vm.erik.order_management_system_api.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{email}")
    public CustomerDTO findByEmail(@PathVariable("email")String email){
        return customerService.findByEmail(email);
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return customerService.saveCustomer(customer);
    }

}
