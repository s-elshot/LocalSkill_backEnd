package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CustomerService {

    public Collection<Customer> getAllCustomers();

    public long createCustomer(Customer customer);

    public void updateCustomer(long id, Customer customer);

    public  void deleteCustomer(long id);

    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);

    public List<Customer> findAllByAreaCodeEquals (String areaCode);

    public Collection<Customer> findByGuildEquals(String guild);

    public Optional<Customer> getCustomerById(long id);

    public boolean customerExistsById(long id);


}
