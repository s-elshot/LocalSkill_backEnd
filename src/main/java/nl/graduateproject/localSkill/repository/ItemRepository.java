package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.CustomerType;
import nl.graduateproject.localSkill.model.Item;
import nl.graduateproject.localSkill.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameStartsWith(String name);

    Collection<Item> getItemsByCustomer(Customer customer);

    Collection<Item> getItemByItemType(ItemType itemType);

    Collection<Item> findItemByNameContains(String name);
}
