package vm.erik.order_management_system_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vm.erik.order_management_system_api.dto.OrderLineDTO;
import vm.erik.order_management_system_api.exeption.OrderLineNotFoundException;
import vm.erik.order_management_system_api.mapper.CustomerMapper;
import vm.erik.order_management_system_api.mapper.OrderLineMapper;
import vm.erik.order_management_system_api.mapper.ProductMapper;
import vm.erik.order_management_system_api.model.Customer;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.model.OrderLine;
import vm.erik.order_management_system_api.model.Product;
import vm.erik.order_management_system_api.repository.OrderLineRepository;
import vm.erik.order_management_system_api.service.OrderLineService;
import vm.erik.order_management_system_api.service.OrderService;
import vm.erik.order_management_system_api.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final OrderService orderService;
    private final CustomerMapper customerMapper;
    private final ProductService productService;
    private final ProductMapper productMapper;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper, OrderService orderService, CustomerMapper customerMapper, ProductService productService, ProductMapper productMapper) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
        this.orderService = orderService;
        this.customerMapper = customerMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }


    @Override
    public OrderLineDTO saveOrderLine(OrderLineDTO orderLine) {
        OrderLine orderLineToSave = orderLineMapper.fromOrderLineDTOtoOrderLine(orderLine);
        Customer customer = customerMapper.fromCustomerDTOToCustomer(orderLine.getCustomer());
        orderLineToSave.setCustomer(customer);
        orderLineToSave.setDateOfSubmission(LocalDateTime.now());
        orderLineRepository.save(orderLineToSave);
        return orderLineMapper.fromOrderLineToOrderLineDTO(orderLineToSave);
    }

    @Override
    public OrderLine loadOrderLineByOrderLineId(UUID orderLineId) {
        Optional<OrderLine> optionalOrderLine = orderLineRepository.findById(orderLineId);
        if (optionalOrderLine.isEmpty()) {
            throw new OrderLineNotFoundException(orderLineId);
        }
        return optionalOrderLine.get();
    }

    @Override
    public void addOrderToOrderLineByOrderLineIdAndOrderId(UUID orderLineId, UUID orderId) {
        OrderLine orderLine = loadOrderLineByOrderLineId(orderLineId);
        Order order = orderService.loadOrderByOrderId(orderId);
        orderLine.addOrderToOrderLine(order);
        orderLine.setDateOfSubmission(LocalDateTime.now());
        orderLineRepository.save(orderLine);
    }


    @Override
    public List<OrderLineDTO> getOrderLinesByCustomerId(UUID customerId) {
        List<OrderLine> orderLines = orderLineRepository.getOrderLinesByCustomerId(customerId);
        return orderLines.stream().map(orderLineMapper::fromOrderLineToOrderLineDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderLineDTO> getOrderLinesByProductName(String name) {
        Product product = productMapper.fromProductDTOToProduct(productService.findByName(name));
        List<OrderLine> orderLines = orderLineRepository.findAll().stream().filter(orderLine -> orderLine.getOrders().contains(product)).toList();
        return orderLines.stream().map(orderLineMapper::fromOrderLineToOrderLineDTO).collect(Collectors.toList());
    }
}
