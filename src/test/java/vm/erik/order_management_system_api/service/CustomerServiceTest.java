package vm.erik.order_management_system_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vm.erik.order_management_system_api.dto.CustomerDTO;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerServiceTest {


    @Autowired
    private CustomerService underTest;
    CustomerDTO customerDTO;
    @BeforeEach
    void setUp() {
        customerDTO = new CustomerDTO();
        customerDTO.setFullName("Test");
        customerDTO.setEmail("test@mail.com");
        customerDTO.setTelephone("123456");
        customerDTO.setRegistrationCode("TEST001");
    }

    @Test
    void saveCustomer() {

        //given

        CustomerDTO savedUser = underTest.saveCustomer(customerDTO);

        //when
        boolean saveSuccessful = savedUser != null;

        //then
        assertTrue(saveSuccessful);
    }

    @Test
    void findByEmail() {

        //given
        underTest.saveCustomer(customerDTO);

        //when
        boolean searchSuccessful = underTest.findByEmail("test@mail.com").equals(customerDTO);

        //then
        assertTrue(searchSuccessful);
    }
}
