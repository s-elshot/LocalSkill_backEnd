package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.item.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameStartsWith(String name);

    Collection<Item> getItemsByCustomer(Customer customer);

    Collection<Item> getItemByItemType(ItemType itemType);

    Collection<Item> findItemByNameContains(String name);


}
