package com.unbreakable.unbreakable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Exercises_AthleticsRepository extends JpaRepository<Exercises_Athletics, String> {
}
