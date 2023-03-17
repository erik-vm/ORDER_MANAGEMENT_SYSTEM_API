package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.repository.OrderRepository;
import vm.erik.order_management_system_api.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) {
        return orderRepository.findAllByDateOfSubmission(date);
    }
}
