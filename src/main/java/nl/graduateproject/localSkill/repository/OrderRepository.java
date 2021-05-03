package nl.graduateproject.localSkill.repository;


import nl.graduateproject.localSkill.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;




public interface OrderRepository extends JpaRepository<Order, Long> {
//List<Order> findAllByNameh(String name);
}
