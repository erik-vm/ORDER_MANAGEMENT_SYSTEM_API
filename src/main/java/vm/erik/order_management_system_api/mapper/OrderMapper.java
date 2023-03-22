package vm.erik.order_management_system_api.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.model.Order;

@Service
public class OrderMapper {

    private final ProductMapper productMapper;

    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderDTO fromOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        orderDTO.setProduct(productMapper.fromProductToProductDTO(order.getProduct()));
        return orderDTO;
    }

    public Order fromOrderDTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;
    }
}
