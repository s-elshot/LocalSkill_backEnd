package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.ItemsOnInvoice;
import nl.graduateproject.localSkill.payload.InvoiceRequestDto;
import nl.graduateproject.localSkill.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestInvoiceService {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceRepository invoiceRepository;

    @Test
    void test_createInvoice(){
        InvoiceRequestDto invoiceDto = new InvoiceRequestDto();
//        invoiceDto.setCustomer("Stephan");
        invoiceDto.setDescription("testBvS1");
        ItemsOnInvoice itemsOnInvoice = new ItemsOnInvoice();

        Long idNewInvoice =  invoiceService.createInvoice(invoiceDto);
        Invoice invoice = invoiceService.getInvoiceById(idNewInvoice).orElse(null);

    }
}