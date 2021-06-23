package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface CustomerService {



    public long createCustomer(Customer customer);
    public void updateCustomer(long id, Customer customer);
    public  void deleteCustomer(long id);
    public Collection<Customer> getAllCustomers();
    public Optional<Customer> getCustomerById(long id);
//    public Optional<Customer> loadCustomerByEmail(String email);
    public boolean customerExistsById(long id);

    public abstract Set<Authority> getAuthorities(String userName);
    public abstract void addAuthority(String userName, String authority);
    public abstract void removeAuthority(String userName, String authority);

    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);
    public List<Customer> findAllByAreaCodeEquals (String areaCode);
    public Collection<Customer> findByGuildEquals(String guild);



}
