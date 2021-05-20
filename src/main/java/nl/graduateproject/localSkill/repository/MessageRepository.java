package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
