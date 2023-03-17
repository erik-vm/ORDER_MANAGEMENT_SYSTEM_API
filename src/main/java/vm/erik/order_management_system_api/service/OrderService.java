package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    public Order saveOrder(Order order);

    List<Order> getOrdersByDate(LocalDate date);
}
