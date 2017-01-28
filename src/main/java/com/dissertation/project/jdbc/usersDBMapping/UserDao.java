package com.dissertation.project.jdbc.usersDBMapping;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.sql.DataSource;
import java.util.List;

public interface UserDao extends JpaRepository<Users, Long> {

     void setDataSource(DataSource ds);

     void create(Users user);

//     List<Users> select(long id, String login);

//     Object selectAll();

     Users getUser(long id);

     List<Users> listUsers();

     void delete(long id);

     void update(long id, String login);

     Users findByLogin(String login);

}
