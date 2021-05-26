package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Message;
import nl.graduateproject.localSkill.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Collection<Message> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getMessageById(long id) {
        if (!messageRepository.existsById(id)) throw new RecordNotFoundException();
        return messageRepository.findById(id);
    }

    @Override
    public void updateMessage(long id, Message message) {
        if (!messageRepository.existsById(id)) throw new RecordNotFoundException();
        Message existingMessage = messageRepository.findById(id).get();
        existingMessage.setTitle(message.getTitle());
        existingMessage.setBodyText(message.getBodyText());
        existingMessage.setDate(message.getDate());
        existingMessage.setCustomer(message.getCustomer());
        messageRepository.save(existingMessage);
    }

    @Override
    public long createMessage(Message message) {
        Message newMessage = messageRepository.save(message);
        return newMessage.getId();
    }

    @Override
    public void deleteMessage(long id) {
        if (!messageRepository.existsById(id)) throw new RecordNotFoundException();
        messageRepository.deleteById(id);
    }

    @Override
    public boolean messageExistsById(long id) {
        return messageRepository.existsById(id);
    }

}
