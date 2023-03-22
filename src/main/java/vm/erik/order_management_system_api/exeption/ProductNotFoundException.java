package vm.erik.order_management_system_api.exeption;

import jakarta.persistence.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException {

    public ProductNotFoundException(String name) {
        super(String.format("Product with name: %s was not found!", name));
    }
}
