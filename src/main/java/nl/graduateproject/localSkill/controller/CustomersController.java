package nl.graduateproject.localSkill.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value= "/customers")
public class CustomersController {

    @GetMapping(value = "")
    public ResponseEntity<Object> getMessage (){
        return new ResponseEntity<>("Secured Rest endpoint: /customers", HttpStatus.OK);
    }
}
