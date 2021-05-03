package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByNameStartsWith(String name);
}
