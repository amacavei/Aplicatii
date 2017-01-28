package com.dissertation.project.jdbc.rolesDBMapping;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleJDBCtemplate implements RoleDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Roles role){

        String sql = "Insert into Roles(ID, NAME) VALUES (:id, :name)";

        Map parameters = new HashMap();
        parameters.put("ID", role.getId());
        parameters.put("NAME", role.getName());

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------RolesRecord---------");
    }

    @Override
    public Roles getRole(long id){
        String SQL = "SELECT * FROM ROLES WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
        Roles role = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, (RowMapper<Roles>) new RoleRowMapper());
        return role;
    }

    @Override
    public List<Roles> listRoles(){
        String SQL = "select * from ROLES";
        List<Roles> roles = namedParameterJdbcTemplate.query(SQL, (RowMapper<Roles>) new RoleRowMapper());

        return roles;
    }

    @Override
    public void delete(long id){
        String SQL = "delete from ROLES where id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted role with id = " + id);
    }


    @Override
    public void update(long id, String role){
        String SQL = "update Roles set NAME = :role WHERE id = :id";
        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("name",role);

        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated role with id = "+ id);
    }
}
