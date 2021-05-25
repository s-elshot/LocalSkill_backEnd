package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.Image;
import nl.graduateproject.localSkill.model.TestKlasse;
import nl.graduateproject.localSkill.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/image")
// remove when working
@CrossOrigin("*")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping(value = "")
    public ResponseEntity<Object> saveImage() {
        return null;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getImages() {
        return ResponseEntity.ok().body(imageService.getImages());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getImage(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(imageService.getItemById(id));
    }

//    @PostMapping(value = "")
//    public ResponseEntity<Object> createImage(@RequestBody Image image) {
//        long newId = imageService.createImage(image);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(newId).toUri();
//        return ResponseEntity.created(location).build();
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteImage(@PathVariable("id") long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

}