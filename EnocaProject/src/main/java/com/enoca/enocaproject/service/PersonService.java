package com.enoca.enocaproject.service;

import com.enoca.enocaproject.entity.Person;
import com.enoca.enocaproject.repositories.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    final PersonnelRepository personnelRepository;

    public Person savePerson (Person person){
       return personnelRepository.save(person);
    }

    public Person updatePerson(Person person){
        return personnelRepository.saveAndFlush(person);
    }

    public void deletePerson(Long personId){
        personnelRepository.deleteById(personId);
    }

    public List<Person> listPerson(){
        return personnelRepository.findAll();
    }
}
