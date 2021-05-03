package nl.graduateproject.localSkill.controller;


import nl.graduateproject.localSkill.model.order.Order;

import nl.graduateproject.localSkill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrdersById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        long newId = orderService.createOrder(order);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }


}
