package vm.erik.order_management_system_api.controller;

import org.springframework.web.bind.annotation.*;
import vm.erik.order_management_system_api.dto.OrderLineDTO;
import vm.erik.order_management_system_api.service.OrderLineService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-line")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @PostMapping("/")
    public OrderLineDTO saveOrderLine(@RequestBody OrderLineDTO orderLine) {
        return orderLineService.saveOrderLine(orderLine);
    }

    @PutMapping("/oli{orderLineId}/ori{orderId}")
    public void addOrderToOrderLineByOrderLineIdAndOrderId(@PathVariable("orderLineId") UUID orderLineId,
                                                           @PathVariable("orderId") UUID orderId) {
        orderLineService.addOrderToOrderLineByOrderLineIdAndOrderId(orderLineId, orderId);
    }

    @GetMapping("/cid{customerId}")
    public List<OrderLineDTO> getOrderLinesByCustomerId(@PathVariable("customerId") UUID customerId) {
        return orderLineService.getOrderLinesByCustomerId(customerId);
    }

    @GetMapping("/prod{name}")
    public List<OrderLineDTO> getOrderLinesByProductName(@PathVariable("name") String name) {
        return orderLineService.getOrderLinesByProductName(name);
    }
}
