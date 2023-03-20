package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.CustomerDTO;
import vm.erik.order_management_system_api.model.Customer;

public interface CustomerService {

    public CustomerDTO saveCustomer(CustomerDTO customer);
    public CustomerDTO findByEmail(String email);


}
