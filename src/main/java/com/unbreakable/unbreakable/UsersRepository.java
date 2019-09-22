package com.unbreakable.unbreakable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource
public interface UsersRepository extends JpaRepository<Users, String> {
   Users findByUsername(String username);

   @Transactional
   Long deleteByUsername(String username);

}
