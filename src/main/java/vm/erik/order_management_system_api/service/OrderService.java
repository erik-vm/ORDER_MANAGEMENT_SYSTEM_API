package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.model.Order;

import java.util.UUID;

public interface OrderService {

    public OrderDTO saveNewOrder(OrderDTO order);

    public Order loadOrderByOrderId(UUID orderId);

    public void changeProductQuantityByOrderId(UUID orderId, int quantity);

}
