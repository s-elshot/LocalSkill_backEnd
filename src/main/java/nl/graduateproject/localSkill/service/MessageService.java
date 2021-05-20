package nl.graduateproject.localSkill.service;
import nl.graduateproject.localSkill.model.message.Message;

import java.util.Collection;
import java.util.Optional;

public interface MessageService {

    public abstract long createMessage(Message message);

    public abstract void deleteMessage(long id);

    public abstract Collection<Message> getMessages();

    public abstract Optional<Message> getMessageById(long id);

    public abstract boolean messageExistsById(long id);
}
