package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

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
    public ResponseEntity<Object> getItems(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(itemService.getItemById(id));
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

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> partialUpdateItem(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        itemService.partialUpdateItem(id, fields);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }


}
