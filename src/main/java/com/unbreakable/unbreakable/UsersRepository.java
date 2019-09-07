package com.unbreakable.unbreakable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UsersRepository extends JpaRepository<Users, String> {
   Users findByUsername(String username);
}
