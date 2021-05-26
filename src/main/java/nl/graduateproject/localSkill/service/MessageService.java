package nl.graduateproject.localSkill.service;
import nl.graduateproject.localSkill.model.Message;
import nl.graduateproject.localSkill.model.TestKlasse;

import java.util.Collection;
import java.util.Optional;

public interface MessageService {

    public long createMessage(Message message);

    public void deleteMessage(long id);

    public Collection<Message> getMessages();

    public Optional<Message> getMessageById(long id);

    public void updateMessage(long id, Message message);

    public boolean messageExistsById(long id);
}
