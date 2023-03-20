package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    public OrderDTO saveOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByDate(LocalDate date);

    List<OrderDTO> getOrdersByProductId(UUID productId);
    List<OrderDTO> getOrdersByCustomerId(UUID customerId);
}
