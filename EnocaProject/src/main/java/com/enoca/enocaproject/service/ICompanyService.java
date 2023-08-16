package com.enoca.enocaproject.service;
import com.enoca.enocaproject.entity.Company;
import com.enoca.enocaproject.entity.projections.IPerson;

import java.util.List;

public interface ICompanyService {
    public Company save(Company company);
    public Company update(Company company);
    public void delete(Long companyId);
    public List<Company> list();

    List<IPerson> listCompanyPerson(Long companyId);

    List<IPerson> getPersonByCompanyName(String companyName);
}
