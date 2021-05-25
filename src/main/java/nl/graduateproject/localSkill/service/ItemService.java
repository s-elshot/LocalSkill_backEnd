package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Item;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemService {


    public abstract Collection<Item> getItemsByName(String name);

    public abstract long createItem(Item item);

    public abstract void updateItem(long id, Item item);

    public abstract void partialUpdateItem(long id, Map<String, String> fields);

    public abstract void deleteItem(long id);

    public abstract Collection<Item> getItems();

    public abstract Optional<Item> getItemById(long id);

//    public abstract Collection<Item> getItemsByAreaCode(String areaCode);

    List<Customer> findItemsByCustomerAreaCode(String areaCode);

//    List<Customer> findItemsByCustomerAreaCode(String areaCode);

    public abstract boolean itemExistsById(long id);




//    public abstract long createItem(Item item);
////    public abstract void updateItem (long id, Item item);
//    Optional<Item> getItemById(long id);
////    public abstract void partialUpdateItem(long id, Map<String, String> fields);
//    public abstract void deleteItem(long id);
//    public abstract Collection<Item> getItems();


}
