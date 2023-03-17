package vm.erik.order_management_system_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vm.erik.order_management_system_api.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {


    List<Order> findAllByDateOfSubmission(LocalDate date);

    @Query(value = "select * from orders where order_id in (select o.order_id from products_order as o where o.product_id=:productId)", nativeQuery = true)
    List<Order> findAllByProductId(@Param("productId")UUID productId);
    @Query(value = "select o from Order as o where o.customer.customerId =:customerId")
    List<Order> findAllByCustomerId(@Param("customerId") UUID customerId);
}
