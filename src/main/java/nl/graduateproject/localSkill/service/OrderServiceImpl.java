package nl.graduateproject.localSkill.service;//package com.graduateproject.localSkill.service;
//
//import com.graduateproject.localSkill.model.Item.Item;
//import com.graduateproject.localSkill.model.exception.RecordNotFoundException;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.order.Order;
import nl.graduateproject.localSkill.repository.ItemRepository;
import nl.graduateproject.localSkill.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Collection<Order> getOrders() {
        return orderRepository.findAll();
    }

//    @Override
//    public Collection<Item> getItemsByName(String name){
//        return itemRepository.findAllByNameStartsWith(name);
//    }

    @Override
    public long createOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder.getId();
    }

//    public List<Item> getItemByName(String name) {
//        return orderRepository.findAllByNameStartsWith(name);
//    }

    @Override
    public void updateOrder(long id, Order order) {
        if (!orderRepository.existsById(id)) throw new RecordNotFoundException();
        Order newOrder = orderRepository.findById(id).get();
//        Order.setName(newItem.getName());
        orderRepository.save(newOrder);
    }

    @Override
    public void partialUpdateOrder(long id, Map<String, String> fields) {

    }

    @Override
    public void deleteOrder(long id) {
        if (!orderRepository.existsById(id)) throw new RecordNotFoundException();
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        if (!orderRepository.existsById(id)) throw new RecordNotFoundException();
        return orderRepository.findById(id);
    }

    @Override
    public boolean orderExistsById(long id) {
        return orderRepository.existsById(id);
    }
}
