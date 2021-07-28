package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.ItemOnInvoice;
import nl.graduateproject.localSkill.service.ItemsOnInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/testklasse")
// remove when working
@CrossOrigin("*")
public class ItemsOnInvoicesController {

    @Autowired
    private ItemsOnInvoiceService itemsOnInvoiceService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllItemsOnInvoices() {
        return ResponseEntity.ok().body(itemsOnInvoiceService.getItemsOnInvoices());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getItemsOnInvoice(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(itemsOnInvoiceService.getItemsOnInvoiceById(id));
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> createItemsOnInvoice(@RequestBody ItemOnInvoice itemOnInvoice) {
        long newId = itemsOnInvoiceService.createItemsOnInvoice(itemOnInvoice);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateItemsOnInvoice(@PathVariable("id") long id, @RequestBody ItemOnInvoice itemOnInvoice) {
        itemsOnInvoiceService.updateItemsOnInvoice(id, itemOnInvoice);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteItemsOnInvoice(@PathVariable("id") long id) {
        itemsOnInvoiceService.deleteItemsOnInvoice(id);
        return ResponseEntity.noContent().build();
    }
}