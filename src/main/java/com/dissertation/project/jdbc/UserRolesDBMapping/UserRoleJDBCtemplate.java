package com.dissertation.project.jdbc.UserRolesDBMapping;

import com.dissertation.project.jdbc.usersDBMapping.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRoleJDBCtemplate implements UserRoleDao {

        private DataSource dataSource;
        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

//    @Override
//    public void create(UserRoles userRole){
//
//        String sql = "Insert into USERS_ROLES(ID, ID_USER, ID_ROLE) VALUES (:id, :id_user, :id_role)";
//
//        Map parameters = new HashMap();
//        parameters.put("ID", userRole.getId());
//        parameters.put("ID_USER", userRole.getId_user());
//        parameters.put("ID_ROLE", userRole.getId_role());
//
//        this.namedParameterJdbcTemplate.update(sql, parameters);
//        System.out.println("----------UserRolesRecord---------");
//    }
//
//    @Override
//    public UserRoles getUserRole(long id){
//        String SQL = "SELECT * FROM USERS_ROLES WHERE id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
//        UserRoles useRole = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, (RowMapper<UserRoles>) new UserRoleRowMapper());
//        return useRole;
//    }
//
//    @Override
//    public List<UserRoles> listUserRoles(){
//        String SQL = "select * from USERS_ROLES";
//        List<UserRoles> userRoles = namedParameterJdbcTemplate.query(SQL, (RowMapper<UserRoles>) new UserRoleRowMapper());
//
//        return userRoles;
//    }
//
//    @Override
//    public void delete(long id){
//        String SQL = "delete from USERS_ROLES where id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
//        namedParameterJdbcTemplate.update(SQL,namedParameters);
//        System.out.println("Deleted role with id = " + id);
//    }




//    @Override
//    public void update(long id, String role){
//        String SQL = "update Roles set NAME = :role WHERE id = :id";
//        Map parameters = new HashMap();
//        parameters.put("id",id);
//        parameters.put("name",role);
//
//        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
//        namedParameterJdbcTemplate.update(SQL,namedParameters);
//        System.out.println("Updated role with id = "+ id);
//    }
}
