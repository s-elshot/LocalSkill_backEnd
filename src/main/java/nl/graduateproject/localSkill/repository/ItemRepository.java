package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByNameStartsWith(String name);
//    List<Item> findItemByCustomerAreaCodeMatches(String areaCode);
    List<Customer> findItemsByCustomerAreaCode(String areaCode);


}
