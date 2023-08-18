package com.enoca.enocaproject.restController;

import com.enoca.enocaproject.config.Rest;
import com.enoca.enocaproject.entity.Company;
import com.enoca.enocaproject.entity.projections.IPerson;
import com.enoca.enocaproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyRestController {
    final CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Company company){
        Rest rest;
        try {
            companyService.save(company);
            rest = new Rest(true,company);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Company company){
        Rest rest;
        try {
            companyService.update(company);
            rest = new Rest(true,company);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @PostMapping("/delete/{companyId}")
    public ResponseEntity delete(@PathVariable Long companyId ){
        try {
            companyService.delete(companyId);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("İşlem Başarılı", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        List<Company> allPerson;
        Rest rest;
        try {
            allPerson = companyService.list();
            rest = new Rest(true,allPerson);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @GetMapping("/list/{companyId}")
    public ResponseEntity listCompanyPerson(@PathVariable Long companyId){
        List<IPerson> allPerson;
        Rest rest;
        try {
            allPerson = companyService.listCompanyPerson(companyId);
            rest = new Rest(true,allPerson);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }

    @GetMapping("/listPersonByCompany")
    public ResponseEntity listCompanyPerson(@RequestBody Company company){
        List<IPerson> allPerson;
        Rest rest;
        try {
            allPerson = companyService.getPersonByCompanyName(company.getCompanyName());
            rest = new Rest(true,allPerson);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rest, HttpStatus.OK);
    }
}
