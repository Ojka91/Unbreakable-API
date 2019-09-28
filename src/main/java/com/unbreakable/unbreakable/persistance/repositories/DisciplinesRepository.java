package com.unbreakable.unbreakable.persistance.repositories;

import com.unbreakable.unbreakable.persistance.Disciplines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DisciplinesRepository extends JpaRepository <Disciplines, String> {
}
