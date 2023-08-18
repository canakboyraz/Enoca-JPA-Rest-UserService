package com.enoca.enocaproject.repositories;

import com.enoca.enocaproject.entity.Company;
import com.enoca.enocaproject.entity.Person;
import com.enoca.enocaproject.entity.projections.IPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "select p.*,c.company_name from person as p inner join person_person_company ppc on p.person_id = ppc.person_person_id inner join company c on ppc.person_company_company_id = c.company_id  where ppc.person_company_company_id =?1",nativeQuery = true)
    List<IPerson> getPersonForCompany(Long companyId);

    @Query(value = "select p.*,c.company_name from person as p inner join person_person_company ppc on p.person_id = ppc.person_person_id inner join company c on ppc.person_company_company_id = c.company_id where c.company_name = ?1 ",nativeQuery = true)
    List<IPerson> getPersonByCompanyName(String companyName);
}