package vm.erik.order_management_system_api.controller;

import org.springframework.web.bind.annotation.*;
import vm.erik.order_management_system_api.model.Order;
import vm.erik.order_management_system_api.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{date}")
    List<Order> ordersByDate(@PathVariable("date")LocalDate date){
        return orderService.getOrdersByDate(date);
    }
}
