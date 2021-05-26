package nl.graduateproject.localSkill.repository;


import nl.graduateproject.localSkill.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {

}
