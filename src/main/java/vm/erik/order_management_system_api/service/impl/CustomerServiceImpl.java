package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.dto.CustomerDTO;
import vm.erik.order_management_system_api.mapper.CustomerMapper;
import vm.erik.order_management_system_api.model.Customer;
import vm.erik.order_management_system_api.repository.CustomerRepository;
import vm.erik.order_management_system_api.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        Customer customerFromCustomerDTO = customerMapper.fromCustomerDTOToCustomer(customer);
        customerRepository.save(customerFromCustomerDTO);
        return customerMapper.fromCustomerToCustomerDTO(customerFromCustomerDTO);
    }

    @Override
    public CustomerDTO findByEmail(String email) {
        return customerMapper.fromCustomerToCustomerDTO(customerRepository.findByEmail(email));
    }


}
