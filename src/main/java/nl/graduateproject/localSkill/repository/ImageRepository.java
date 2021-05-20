package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
