package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.exceptions.BadRequestException;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import nl.graduateproject.localSkill.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;


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

    @GetMapping(value = "/{username}")
    public ResponseEntity<Object> getCustomerByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(customerService.getCustomerByUsername(username));
    }

    @GetMapping(value = "/role/{userRole}")
    public ResponseEntity<Object> getUserByRole(@PathVariable("userRole") CustomerType userRole) {
        return ResponseEntity.ok(customerService.findByUserRoleEquals(userRole));
    }

    @GetMapping(value = "area/{areaCode}")
    public ResponseEntity<Object> getCustomerByAreaCode(@PathVariable("areaCode") String areaCode) {
        return ResponseEntity.ok().body(customerService.findAllByAreaCodeEquals(areaCode));
    }

    @GetMapping(value = "guild/{guild}")
    public ResponseEntity<Object> getCustomersByGuild(@PathVariable("guild")CustomerGuild customerGuild) {
        return ResponseEntity.ok(customerService.findByCustomerGuildEquals(customerGuild));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        String newUsername = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("username") String username, @RequestBody Customer customer) {
        customerService.updateCustomer(username, customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("username")String username) {
        customerService.deleteCustomer(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addCustomerAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            customerService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        customerService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}
