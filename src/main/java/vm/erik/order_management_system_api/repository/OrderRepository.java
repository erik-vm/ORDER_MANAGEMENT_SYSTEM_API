package vm.erik.order_management_system_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vm.erik.order_management_system_api.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {


    List<Order> findAllByDateOfSubmission(LocalDate date);
}
