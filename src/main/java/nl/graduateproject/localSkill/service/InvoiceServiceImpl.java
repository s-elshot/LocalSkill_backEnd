package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public long createInvoice(Invoice invoice) {
        Invoice newInvoice = invoiceRepository.save(invoice);
        return newInvoice.getId();
    }

    @Override
    public void updateInvoice(long id, Invoice invoice) {

    }

    @Override
    public void deleteInvoice(long id) {
        if (!invoiceRepository.existsById(id)) throw new RecordNotFoundException();
        invoiceRepository.deleteById(id);
    }

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
    public boolean invoiceExistsById(long id) {
        return invoiceRepository.existsById(id);
    }
}
