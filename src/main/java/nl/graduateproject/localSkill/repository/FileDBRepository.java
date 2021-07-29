package nl.graduateproject.localSkill.repository;


import nl.graduateproject.localSkill.model.fileDB.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<Image, String> {

}

