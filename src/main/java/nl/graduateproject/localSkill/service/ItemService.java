package nl.graduateproject.localSkill.service;//package com.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Item.Item;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemService {


    Collection<Item> getItemsByName(String name);

    long createItem(Item item);

    public abstract void updateItem(long id, Item item);

    public abstract void partialUpdateItem(long id, Map<String, String> fields);

    public abstract void deleteItem(long id);

    public abstract Collection<Item> getItems();

    public abstract Optional<Item> getItemById(long id);

    public abstract boolean itemExistsById(long id);


//    Collection<Item> findAll();
////    List<Item> findAll();
//    Item getItemById(long id);
//    Collection<Item> getItems(String name);
//    long createItem(Item item);
//    void  updateItem(long id, Item item);
//    void partialUpdateItem(long id, Map<String,String> fields);
//    List<Item>getItemNameStartsWith(String name);
//    void deleteItem(long id);

//    public abstract long createItem(Item item);
////    public abstract void updateItem (long id, Item item);
//    Optional<Item> getItemById(long id);
////    public abstract void partialUpdateItem(long id, Map<String, String> fields);
//    public abstract void deleteItem(long id);
//    public abstract Collection<Item> getItems();


//    public abstract Collection<Item> getItemsByDescription (String description);
//    public abstract Collection<Item> getItemsByGuild (String guild);
//    public abstract Collection<Item> findAll();

//    public abstract Optional<Item> getItemsById(long id);
//    public abstract boolean itemExistsById(Long id);


}
