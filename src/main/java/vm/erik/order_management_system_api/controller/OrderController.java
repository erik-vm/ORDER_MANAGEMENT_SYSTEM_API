package vm.erik.order_management_system_api.controller;

import org.springframework.web.bind.annotation.*;
import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.service.OrderService;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public OrderDTO saveOrder(@RequestBody OrderDTO order) {
        return orderService.saveNewOrder(order);
    }

    @PutMapping("/order{orderId}/q{quantity}")
    public void changeProductQuantityByOrderId(@PathVariable("orderId") UUID orderId, @PathVariable("quantity") int quantity) {
        orderService.changeProductQuantityByOrderId(orderId, quantity);
    }
}
