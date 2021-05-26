package nl.graduateproject.localSkill.service;


import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.CustomerType;
import nl.graduateproject.localSkill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


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
        customer.setAreaCode(newCustomer.getAreaCode());
        customer.setCity(newCustomer.getCity());
        customer.setPassword(newCustomer.getPassword());
        customer.setGuild(newCustomer.getGuild());
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


}
