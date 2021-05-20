package nl.graduateproject.localSkill.service;//package com.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.order.Order;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface OrderService {


    public abstract long createOrder(Order order);

    public abstract void updateOrder(long id, Order order);

    public abstract void partialUpdateOrder(long id, Map<String, String> fields);

    public abstract void deleteOrder(long id);

    public abstract Collection<Order> getOrders();

    public abstract Optional<Order> getOrderById(long id);

    public abstract boolean orderExistsById(long id);


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
