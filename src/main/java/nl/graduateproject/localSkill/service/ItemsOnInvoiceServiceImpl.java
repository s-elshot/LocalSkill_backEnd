package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.model.ItemsOnInvoice;
import nl.graduateproject.localSkill.repository.ItemsOnInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ItemsOnInvoiceServiceImpl implements ItemsOnInvoiceService {

    @Autowired
    private ItemsOnInvoiceRepository itemsOnInvoiceRepository;

    @Override
    public void deleteItemsOnInvoice(long id) {
        if (!itemsOnInvoiceRepository.existsById(id)) throw new RecordNotFoundException();
        itemsOnInvoiceRepository.deleteById(id);
    }

    @Override
    public Collection<ItemsOnInvoice> getItemsOnInvoices() {
        return itemsOnInvoiceRepository.findAll();
    }

    @Override
    public Optional<ItemsOnInvoice> getItemsOnInvoiceById(long id) {
        if (!itemsOnInvoiceRepository.existsById(id)) throw new RecordNotFoundException();
        return itemsOnInvoiceRepository.findById(id);
    }

    @Override
    public boolean ItemsOnInvoiceExistsById(long id) {
        return itemsOnInvoiceRepository.existsById(id);
    }

    @Override
    public long createItemsOnInvoice(ItemsOnInvoice itemsOnInvoice) {
        ItemsOnInvoice newItemsOnInvoice = itemsOnInvoiceRepository.save(itemsOnInvoice);
        return newItemsOnInvoice.getId();
    }


    @Override
    public void updateItemsOnInvoice(long id, ItemsOnInvoice itemsOnInvoice) {

    }
}

