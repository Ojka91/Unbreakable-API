package com.unbreakable.unbreakable.persistance.repositories;

import com.unbreakable.unbreakable.persistance.Activities;
import com.unbreakable.unbreakable.persistance.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource
public interface ActivitiesRespository extends JpaRepository<Activities, String> {
    List<Activities> findByUsers(Users user);
    @Transactional
    Long deleteById(int username);
}
