package nl.graduateproject.localSkill.service;//package com.graduateproject.localSkill.service;
//

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Item;
//import nl.graduateproject.localSkill.model.exception.RecordNotFoundException;

import nl.graduateproject.localSkill.model.ItemType;
import nl.graduateproject.localSkill.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Collection<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(long id) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        return itemRepository.findById(id);
    }

    @Override
    public long createItem(Item item) {
        Item newItem = itemRepository.save(item);
        return newItem.getId();
    }

    public List<Item> getItemByName(String name) {
        return itemRepository.findAllByNameStartsWith(name);
    }

    @Override
    public void updateItem(long id, Item item) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        Item existingItem = itemRepository.findById(id).get();
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setDescription(item.getDescription());
        existingItem.setNumber(item.getNumber());
        existingItem.setCount(item.getCount());
        existingItem.setItemType(item.getItemType());
        existingItem.setCustomer(item.getCustomer());
//        existingItem.setImages(item.getImages());
        existingItem.setInvoices(item.getInvoices());
        itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(long id) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        itemRepository.deleteById(id);

    }




    @Override
    public Collection<Item> findItemByNameContains(String name) {
        return itemRepository.findItemByNameContains(name);
    }

    @Override
    public Collection<Item> getItemsByCustomer(Customer customer) {
        return itemRepository.getItemsByCustomer(customer);
    }

    @Override
    public Collection<Item> getItemByItemType(ItemType itemType) {
        return itemRepository.getItemByItemType(itemType);
    }
}
