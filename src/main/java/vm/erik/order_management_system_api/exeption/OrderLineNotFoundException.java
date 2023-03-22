package vm.erik.order_management_system_api.exeption;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class OrderLineNotFoundException extends EntityNotFoundException {

    public OrderLineNotFoundException(UUID orderId) {
        super(String.format("Order line with id: %s was not found!", orderId));
    }
}
