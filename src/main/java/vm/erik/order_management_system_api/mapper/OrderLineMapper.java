package vm.erik.order_management_system_api.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.order_management_system_api.dto.OrderLineDTO;
import vm.erik.order_management_system_api.model.OrderLine;

@Service
public class OrderLineMapper {

    private final CustomerMapper customerMapper;

    public OrderLineMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public OrderLineDTO fromOrderLineToOrderLineDTO(OrderLine orderLine) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        BeanUtils.copyProperties(orderLineDTO, orderLineDTO);
        orderLineDTO.setCustomer(customerMapper.fromCustomerToCustomerDTO(orderLine.getCustomer()));
        return orderLineDTO;
    }

    public OrderLine fromOrderLineDTOtoOrderLine(OrderLineDTO orderLineDTO) {
        OrderLine orderLine = new OrderLine();
        BeanUtils.copyProperties(orderLineDTO, orderLine);
        return orderLine;
    }
}
