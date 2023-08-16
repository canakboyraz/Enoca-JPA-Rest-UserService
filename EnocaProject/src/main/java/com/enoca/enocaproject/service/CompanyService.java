package com.enoca.enocaproject.service;

import com.enoca.enocaproject.entity.Company;
import com.enoca.enocaproject.entity.projections.IPerson;
import com.enoca.enocaproject.repositories.CompanyRepository;
import com.enoca.enocaproject.repositories.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {
    final CompanyRepository companyRepository;
    private final PersonnelRepository personnelRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void delete(Long companyId) {
        companyRepository.deleteById(companyId);
    }


    @Override
    public List<Company> list() {
       return companyRepository.findAll();
    }

    @Override
    public List<IPerson> listCompanyPerson(Long companyId){
        return companyRepository.getPersonForCompany(companyId);
    }
    @Override
    public List<IPerson> getPersonByCompanyName(String companyName){
        return companyRepository.getPersonByCompanyName(companyName);
    }


}
