package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.ItemOnInvoice;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.payload.InvoiceRequestDto;
import nl.graduateproject.localSkill.payload.ItemsOnInvoiceRequestDto;
import nl.graduateproject.localSkill.repository.InvoiceRepository;
import nl.graduateproject.localSkill.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Collection<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getInvoiceById(long id) {
        if (!invoiceRepository.existsById(id)) throw new RecordNotFoundException();
        return invoiceRepository.findById(id);
    }

    @Override
    public void updateInvoice(long id, Invoice invoice) {
        if (!invoiceRepository.existsById(id)) throw new RecordNotFoundException();
        Invoice existingInvoice = invoiceRepository.findById(id).get();
        existingInvoice.setDescription(invoice.getDescription());
        existingInvoice.setTotalPrice(invoice.getTotalPrice());
        existingInvoice.setCustomer(invoice.getCustomer());

        invoiceRepository.save(existingInvoice);
    }

    @Override
    public long createInvoice(InvoiceRequestDto invoiceDto) {
        Invoice invoice = new Invoice();
        invoice.setDescription(invoiceDto.getDescription());
        invoice.setTotalPrice(invoiceDto.getTotalPrice());
        invoice.setCustomer(invoiceDto.getCustomer());
//        invoice.setMessage(invoiceDto.getMessage());

        for (ItemsOnInvoiceRequestDto itemDto: invoiceDto.getItemsOnInvoice()) {

            Item item = itemRepository.findById(itemDto.getId()).orElse(null);

//            if (item = null){
//                throw RecordNotFoundException;
//            }
            // af vangen slechte data
            ItemOnInvoice itemsOnInvoice = new ItemOnInvoice();
            //hieronder werkt NIET!! Dit zet in de tabel items_on_invoice de id maar niet item_id
            //itemsOnInvoice.setId(item.getId());
            itemsOnInvoice.setItem(item);//Maar dit werkt wel! De rest gaat wel stuk!
//            itemsOnInvoice.setQuantity(itemDto.getCount());
//            itemOnInvoice.setAmount(itemDto.getAmount());
            invoice.getItemsOnInvoice().add(itemsOnInvoice);
            itemsOnInvoice.setInvoice(invoice);
        }
        invoice.setCustomer(invoiceDto.getCustomer());
//        invoice.setMessage(invoiceDto.getMessage());
        Invoice newInvoice = invoiceRepository.save(invoice);
        return newInvoice.getId();
    }

    @Override
    public void deleteInvoice(long id) {
        if (!invoiceRepository.existsById(id)) throw new RecordNotFoundException();
        invoiceRepository.deleteById(id);
    }

    @Override
    public boolean invoiceExistsById(long id) {
        return invoiceRepository.existsById(id);
    }
}

