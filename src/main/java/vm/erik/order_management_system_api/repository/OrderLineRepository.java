package vm.erik.order_management_system_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vm.erik.order_management_system_api.model.OrderLine;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, UUID> {

    @Query(value = "select ol from OrderLine as ol where ol.customer.customerId =:customerId")
    List<OrderLine> getOrderLinesByCustomerId(@Param("customerId")UUID customerId);

}
