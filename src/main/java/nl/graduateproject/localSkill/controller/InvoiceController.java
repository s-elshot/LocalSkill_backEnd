package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.payload.InvoiceRequestDto;
import nl.graduateproject.localSkill.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/invoice")
// remove when working
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getInvoices() {
        return ResponseEntity.ok().body(invoiceService.getInvoices());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getInvoicesById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(invoiceService.getInvoiceById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createInvoice(@RequestBody InvoiceRequestDto invoiceDto, Customer customer) {
        long newId = invoiceService.createInvoice(invoiceDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateInvoice(@PathVariable("id") long id, @RequestBody Invoice invoice) {
        invoiceService.updateInvoice(id, invoice);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable("id") long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

}
