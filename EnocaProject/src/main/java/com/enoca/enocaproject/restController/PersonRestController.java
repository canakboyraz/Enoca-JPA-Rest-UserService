package com.enoca.enocaproject.restController;

import com.enoca.enocaproject.config.Rest;
import com.enoca.enocaproject.entity.Person;
import com.enoca.enocaproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonRestController {
    final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Person person){
        Rest rest;
        try {
            personService.savePerson(person);
            rest = new Rest(true,person);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Person person){
        Rest rest;
        try {
            personService.updatePerson(person);
            rest = new Rest(true,person);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @PostMapping("/delete/{personId}")
    public ResponseEntity delete(@PathVariable Long personId ){
        try {
            personService.deletePerson(personId);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("İşlem Başarılı", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
            List<Person> allPerson;
            Rest rest;
        try {
            allPerson = personService.listPerson();
            rest = new Rest(true,allPerson);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }


}
