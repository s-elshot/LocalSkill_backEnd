package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.user.Customer;
import nl.graduateproject.localSkill.service.CustomerService;
import nl.graduateproject.localSkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    // controller handles HTTP-requests or API
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/all")
    public ResponseEntity<Object> getItems() {
        return ResponseEntity.ok().body(itemService.getItems());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers(@RequestParam(name = "firstName", defaultValue = "") String firstName,
                                               @RequestParam(name = "lastName", defaultValue = "") String lastName) {
        return ResponseEntity.ok().body(customerService.getCustomers(firstName, lastName));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
