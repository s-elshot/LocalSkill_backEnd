package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Item;
import nl.graduateproject.localSkill.model.TestKlasse;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemService {


    public Collection<Item> getItems();

    public Optional<Item> getItemById(long id);

    public long createItem(Item item);

    public void updateItem(long id, Item item);

    public void deleteItem(long id);;



    public  void partialUpdateItem(long id, Map<String, String> fields);

//    public abstract Collection<Item> getItemsByAreaCode(String areaCode);

//    List<Customer> findItemsByCustomerAreaCode(String areaCode);

//    List<Customer> findItemsByCustomerAreaCode(String areaCode);

//    public Collection<Item> getItemsByName(String name);

//    public boolean itemExistsById(long id);





}
