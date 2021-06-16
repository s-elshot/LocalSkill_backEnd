package nl.graduateproject.localSkill.controller;

import nl.graduateproject.localSkill.model.TestKlasse;
import nl.graduateproject.localSkill.service.TestKlasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/testklasse")
// remove when working
@CrossOrigin("*")
public class TestKlasseController {

    @Autowired
    private TestKlasseService testKlasseService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllTestKlassen() {
        return ResponseEntity.ok().body(testKlasseService.getTestKlassen());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTestKlasse(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(testKlasseService.getTestklassenById(id));
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> createTestKlasse(@RequestBody TestKlasse testKlasse) {
        long newId = testKlasseService.createTestKlasse(testKlasse);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateTestKlasse(@PathVariable("id") long id, @RequestBody TestKlasse testKlasse) {
        testKlasseService.updateTestKlasse(id, testKlasse);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteTestKlasse(@PathVariable("id") long id) {
        testKlasseService.deleteTestKlasse(id);
        return ResponseEntity.noContent().build();
    }
}