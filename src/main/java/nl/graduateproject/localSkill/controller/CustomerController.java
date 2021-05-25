package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.service.CustomerService;
import nl.graduateproject.localSkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/customer")
// remove when working
@CrossOrigin("*")
public class CustomerController {

    // controller handles HTTP-requests or API
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @GetMapping(value = "/{areaCode}")
    public ResponseEntity<Object> getAllByAreaCode(@RequestParam(name = "firstName", defaultValue = "") String firstName,
                                               @RequestParam(name = "lastName", defaultValue = "") String lastName,
                                                @RequestParam(name = "areaCode", defaultValue = "") String areaCode){
        return ResponseEntity.ok(customerService.getCustomersByAreaCode(firstName, lastName, areaCode));
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
