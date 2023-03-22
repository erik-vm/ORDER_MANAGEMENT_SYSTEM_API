package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.CustomerDTO;

public interface CustomerService {

    public CustomerDTO saveCustomer(CustomerDTO customer);

    public CustomerDTO findByEmail(String email);

}
