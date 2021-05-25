package nl.graduateproject.localSkill.service;//package com.graduateproject.localSkill.service;
//

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.Item;
//import nl.graduateproject.localSkill.model.exception.RecordNotFoundException;

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
    public Collection<Item> getItemsByName(String name) {
        return itemRepository.findAllByNameStartsWith(name);
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
    public void updateItem(long id, Item newItem) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        Item item = itemRepository.findById(id).get();
        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());
        item.setDescription(newItem.getDescription());
        item.setNumber(newItem.getNumber());
        item.setItemType(newItem.getItemType());
        itemRepository.save(item);
    }

    @Override
    public void partialUpdateItem(long id, Map<String, String> fields) {

        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        Item item = itemRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "name":
                    item.setName(fields.get(field));
                    break;
                case "price":
                    item.setPrice((Double.parseDouble(fields.get(field))));
                    break;
                case "description":
                    item.setDescription(fields.get(field));
                    break;
//                case "number":
//                    item.setNumber((int) fields.get(field));
//                    break;
//                case "count":
//                    item.setCount((int) fields.get(field));
//                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + field.toLowerCase());
            }
        }
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(long id) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        itemRepository.deleteById(id);
    }

    @Override
    public Optional<Item> getItemById(long id) {
        if (!itemRepository.existsById(id)) throw new RecordNotFoundException();
        return itemRepository.findById(id);
    }



    @Override
    public boolean itemExistsById(long id) {
        return itemRepository.existsById(id);
    }

    @Override
    public List<Customer> findItemsByCustomerAreaCode(String areaCode) {
        return itemRepository.findItemsByCustomerAreaCode(areaCode);
    }


}
