package vm.erik.order_management_system_api.exeption;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class OrderNotFoundException extends EntityNotFoundException {

    public OrderNotFoundException(UUID orderId) {
        super(String.format("Order with id: %s was not found!", orderId));
    }
}
