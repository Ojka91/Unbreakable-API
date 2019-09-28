package com.unbreakable.unbreakable.persistance.repositories;

import com.unbreakable.unbreakable.persistance.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource
public interface UsersRepository extends JpaRepository<Users, String> {
   Users findByUsername(String username);

   @Transactional
   Long deleteByUsername(String username);

}
