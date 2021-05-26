package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.TestKlasse;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CustomerService {

    public Collection<Customer> getCustomersByLastName(String lastName);

    public Collection<Customer> getAllCustomers();

    public Collection<Customer> getCustomersByAreaCode(String firstName, String lastName, String areaCode);

    public Collection<Customer> findAllByAreaCode(String areaCode);

    public long createCustomer(Customer customer);

    public void updateCustomer(long id, Customer customer);

    public  void deleteCustomer(long id);

    public List<Customer> findAllByAreaCodeEquals (String areaCode);

//    public abstract Collection<Customer> getCustomers(String name, String lastName);

    public Optional<Customer> getCustomerById(long id);

    public boolean customerExistsById(long id);


}
