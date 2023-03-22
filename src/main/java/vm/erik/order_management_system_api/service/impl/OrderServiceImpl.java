package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.exeption.OrderNotFoundException;
import vm.erik.order_management_system_api.mapper.OrderMapper;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.repository.OrderRepository;
import vm.erik.order_management_system_api.service.OrderService;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public OrderDTO saveNewOrder(OrderDTO order) {
        Order orderToSave = orderMapper.fromOrderDTOtoOrder(order);
        orderRepository.save(orderToSave);
        return orderMapper.fromOrderToOrderDTO(orderToSave);
    }

    @Override
    public Order loadOrderByOrderId(UUID orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new OrderNotFoundException(orderId);
        }
        return orderOptional.get();
    }

    @Override
    public void changeProductQuantityByOrderId(UUID orderId, int quantity) {
        Order order = loadOrderByOrderId(orderId);
        order.setQuantity(quantity);
        orderRepository.save(order);
    }
}
