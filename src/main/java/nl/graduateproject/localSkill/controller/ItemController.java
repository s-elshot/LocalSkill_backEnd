package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.item.ItemType;
import nl.graduateproject.localSkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/item")
// remove when working
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping(value = "")
    public ResponseEntity<Object> getItems() {
        return ResponseEntity.ok().body(itemService.getItems());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getItem(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(itemService.getItemById(id));
    }

    @GetMapping(value = "name/{name}")
    public ResponseEntity<Object> getItemsByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(itemService.findItemByNameContains(name));
    }

    @GetMapping(value = "itemType/{itemType}")
    public ResponseEntity<Object> getItemsByItemType(@PathVariable("itemType") ItemType itemType) {
    return ResponseEntity.ok(itemService.getItemByItemType(itemType));
    }

    @GetMapping(value = "customer/{customer}")
    public ResponseEntity<Object> getItemsByCustomer(@PathVariable("customer") Customer customer){
        return ResponseEntity.ok(itemService.getItemsByCustomer(customer));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createItem(@RequestBody Item item) {
        long newId = itemService.createItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable("id") long id, @RequestBody Item item) {
        itemService.updateItem(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
