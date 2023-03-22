package vm.erik.order_management_system_api.exeption;

import jakarta.persistence.EntityNotFoundException;

public class CustomerNotFoundException extends EntityNotFoundException {

    public CustomerNotFoundException(String email) {
        super(String.format("Customer with email: %s was not found!", email));
    }
}
