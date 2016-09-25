package com.dissertation.project.persist.repo;

import com.dissertation.project.persist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmarineata on 9/25/2016.
 */
public interface UserRepo extends JpaRepository<User, Long>{
    User findByLogin(String login);
}
