package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.service.InvoiceService;
import nl.graduateproject.localSkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
