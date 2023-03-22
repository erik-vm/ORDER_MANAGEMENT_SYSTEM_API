package vm.erik.order_management_system_api.service;

import vm.erik.order_management_system_api.dto.OrderLineDTO;
import vm.erik.order_management_system_api.model.OrderLine;

import java.util.List;
import java.util.UUID;

public interface OrderLineService {

    public OrderLineDTO saveOrderLine(OrderLineDTO orderLine);

    OrderLine loadOrderLineByOrderLineId(UUID orderLineId);

    public void addOrderToOrderLineByOrderLineIdAndOrderId(UUID orderLineId, UUID orderId);


    List<OrderLineDTO> getOrderLinesByCustomerId(UUID customerId);

    List<OrderLineDTO> getOrderLinesByProductName(String name);
}
