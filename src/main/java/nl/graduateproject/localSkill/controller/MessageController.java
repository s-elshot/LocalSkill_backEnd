package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.message.Message;
import nl.graduateproject.localSkill.service.ItemService;
import nl.graduateproject.localSkill.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping(value = "/message")
// remove when working
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getMessages() {
        return ResponseEntity.ok().body(messageService.getMessages());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getMessage(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(messageService.getMessageById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createMessage(@RequestBody Message message) {
        long newId = messageService.createMessage(message);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMessage(@PathVariable("id") long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

}