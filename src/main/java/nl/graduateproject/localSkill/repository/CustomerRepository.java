package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Collection<Customer> findAllByAreaCode(String areaCode);
    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);
    Optional<Customer> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


    // handles or translates the sql/database requests
    // query - defines methods that can be used in the controller-class


}

