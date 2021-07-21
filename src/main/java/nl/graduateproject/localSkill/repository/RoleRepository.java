package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.customer.ERole;
import nl.graduateproject.localSkill.model.customer.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}