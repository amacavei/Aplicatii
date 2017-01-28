package com.dissertation.project.jdbc.rolesDBMapping;


import javax.sql.DataSource;
import java.util.List;

public interface RoleDao {

    void setDataSource(DataSource ds);

    void create(Roles role);

//     List<Users> select(long id, String login);

//     Object selectAll();

    Roles getRole(long id);

    List<Roles> listRoles();

    void delete(long id);

    void update(long id, String role);
}
