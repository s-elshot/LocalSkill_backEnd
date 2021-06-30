package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    public Collection<Customer> findAllByAreaCode(String areaCode);

    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);

    public Collection<Customer> findByCustomerGuildEquals(CustomerGuild customerGuild);




    // handles or translates the sql/database requests
    // query - defines methods that can be used in the controller-class


}

