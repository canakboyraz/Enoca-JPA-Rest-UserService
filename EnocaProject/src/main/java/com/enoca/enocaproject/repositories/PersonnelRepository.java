package com.enoca.enocaproject.repositories;

import com.enoca.enocaproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Person, Long> {
}