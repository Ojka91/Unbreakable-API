package com.unbreakable.unbreakable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Exercices_CalisthenicsRepository extends JpaRepository<Exercises_Calisthenics, String> {
}
