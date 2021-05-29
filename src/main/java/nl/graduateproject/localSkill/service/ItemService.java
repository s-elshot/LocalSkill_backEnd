package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.item.ItemType;


import java.util.Collection;
import java.util.Optional;

public interface ItemService {


    public Collection<Item> getItems();

    public Optional<Item> getItemById(long id);

    public long createItem(Item item);

    public void updateItem(long id, Item item);

    public void deleteItem(long id);;

//    public  void partialUpdateItem(long id, Map<String, String> fields);

    public Collection<Item> findItemByNameContains(String name);

    public Collection<Item> getItemsByCustomer(Customer customer);

    public Collection<Item> getItemByItemType(ItemType itemType);

//    public Collection<Item> findItemByItemTypeAndCustomer_AreaCode(String areaCode, ItemType itemType);
}
