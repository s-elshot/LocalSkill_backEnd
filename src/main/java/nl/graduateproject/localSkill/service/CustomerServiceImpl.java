package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import nl.graduateproject.localSkill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class CustomerServiceImpl implements CustomerService {

    // create a has-a relationship with Customer-repository
    // implement the service-methods
    // specify all the methods that you can use in your application

    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public Collection<Customer> getCustomers(String firstName, String lastName) {
//        return customerRepository.findAll();
//    }

    @Override
    public Collection<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }

    @Override
    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void updateCustomer(long id, Customer newCustomer) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        Customer customer = customerRepository.findById(id).get();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        customer.setAreaCode(newCustomer.getAreaCode());
        customer.setCity(newCustomer.getCity());
        customer.setPassword(newCustomer.getPassword());
        customer.setUserName(newCustomer.getUserName());
        customer.setGuild(newCustomer.getGuild());
//        customer.setCustomerGuild(newCustomer.getCustomerGuild());
//        customer.setUserRole(newCustomer.getUserRole());
//        customer.setItems(newCustomer.getItems());
//        customer.setMessages(newCustomer.getMessages());
//        customer.setInvoices(newCustomer.getInvoices());
        customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByAreaCodeEquals(String areaCode) {
        return (List<Customer>) customerRepository.findAllByAreaCode(areaCode);
    }

    @Override
    public Collection<Customer> findByUserRoleEquals (CustomerType userRole){
     return (List<Customer>) customerRepository.findByUserRoleEquals(userRole);
    }

    @Override
    public Collection<Customer> findByGuildEquals(String guild) {
        return (List<Customer>) customerRepository.findByGuildEquals(guild);
    }

    @Override
    public boolean customerExistsById(long id) {
        return customerRepository.existsById(id);
    }


    @Override
    public Set<Authority> getAuthorities(String userName) {
        return null;
    }

    @Override
    public void addAuthority(String userName, String authority) {

    }

    @Override
    public void removeAuthority(String userName, String authority) {

    }


//    @Override
//    public Set<Authority> getAuthorities(String userName) {
//        if (!customerRepository.existsByUserName(userName)) throw new UsernameNotFoundException(userName);
//        Customer customer = customerRepository.findById(userName).get();
//        return user.getAuthorities();
//    }
//
//    @Override
//    public void addAuthority(String userName, String authority) {
//        if (!customerRepository.existsByUserName(userName)) throw new UsernameNotFoundException(userName);
//        Customer customer = customerRepository.findById(userName).get();
//        customer.addAuthority(new Authority(userName, authority));
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public void removeAuthority(String userName, String authority) {
//        if (!customerRepository.existsById(userName)) throw new UsernameNotFoundException(userName);
//        Customer customer = customerRepository.findById(userName).get();
//        Authority authorityToRemove = customer.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
//        customer.removeAuthority(authorityToRemove);
//        customerRepository.save(customer);
//    }
}
