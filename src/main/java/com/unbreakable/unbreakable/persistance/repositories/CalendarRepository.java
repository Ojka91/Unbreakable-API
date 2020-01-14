package com.unbreakable.unbreakable.persistance.repositories;

import com.unbreakable.unbreakable.persistance.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CalendarRepository extends JpaRepository<Calendar, String> {
    
}
