package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.mapper.OrderMapper;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.repository.OrderRepository;
import vm.erik.order_management_system_api.service.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public OrderDTO saveOrder(OrderDTO order) {
        Order orderFromOrderDTO = orderMapper.fromOrderDTOtoOrder(order);
        orderRepository.save(orderFromOrderDTO);
        return orderMapper.fromOrderToOrderDTO(orderFromOrderDTO);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::fromOrderToOrderDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByDate(LocalDate date) {
        return orderRepository.findAllByDateOfSubmission(date);
    }

    @Override
    public List<OrderDTO> getOrdersByProductId(UUID productId) {
        return orderRepository.findAllByOrdersContainingProductId(productId);
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(UUID customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }


}
