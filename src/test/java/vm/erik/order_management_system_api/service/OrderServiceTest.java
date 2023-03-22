package vm.erik.order_management_system_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vm.erik.order_management_system_api.dto.OrderDTO;
import vm.erik.order_management_system_api.dto.ProductDTO;
import vm.erik.order_management_system_api.mapper.OrderMapper;
import vm.erik.order_management_system_api.model.Order;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService underTest;
    @Autowired
    private OrderMapper orderMapper;

    private OrderDTO orderDTO;

    @BeforeEach
    void setUp() {
        orderDTO = new OrderDTO();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setSkuCode("ORDER-PROD");
        productDTO.setProductName("ORDER-PROD");
        productDTO.setUnitPrice(12.34);
        orderDTO.setProduct(productDTO);
        orderDTO.setQuantity(5);
    }

    @Test
    void saveNewOrder() {
        //given
        OrderDTO savedOrder = underTest.saveNewOrder(orderDTO);

        //when
        boolean saveSuccessful = savedOrder != null;

        //then
        assertTrue(saveSuccessful);
    }

    @Test
    void loadOrderByOrderId() {
        //given
        OrderDTO savedOrder = underTest.saveNewOrder(orderDTO);
        Order order = orderMapper.fromOrderDTOtoOrder(savedOrder);

        //when
        boolean searchSuccessful = underTest.loadOrderByOrderId(order.getOrderId()).equals(order);

        //then
        assertTrue(searchSuccessful);
    }

    @Test
    void changeProductQuantityByOrderId() {
    }
}
