package com.dissertation.project.jdbc.usersDBMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersJDBCTemplate implements UsersDao {

//    private DataSource dataSource;
//
//    public void setDataSource(DataSource ds) {
//        dataSource = ds;
//    }
//
//    public void create(long id, String firstName ,String familyName, String email, String phone, String language, String pictureId, String login, String password, Date birthDate, Boolean enabled) {
//        JdbcTemplate insert = new JdbcTemplate(dataSource);
//        insert.update("INSERT INTO USERS (ID, FIRST_NAME, FAMILY_NAME, E_MAIL, PHONE, LANGUAGE, ID_PICTURE, LOGIN, PASSWORD, BIRTH_DATE, ENABLED) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
//                new Object[] { id, firstName, familyName, email, phone, language, pictureId, login, password, birthDate, enabled });
//    }
//
//    public List<Users> select(long id, String login) {
//        JdbcTemplate select = new JdbcTemplate(dataSource);
//        return select
//                .query(
//                        "select  ID, LOGIN from USERS where ID = ? AND LOGIN= ?",
//                        new Object[] { id, login },
//                        (RowMapper<Users>) new UserRowMapper());
//    }
//
//    public List<Users> selectAll() {
//        JdbcTemplate select = new JdbcTemplate(dataSource);
//        return (List<Users>) select.query("select * from USERS",
//                new UserResultSetExtractor());
//    }
//
//    public void delete(long id) {
//        JdbcTemplate delete = new JdbcTemplate(dataSource);
//        delete.update("DELETE from USERS where ID = ?",
//                new Object[] { id });
//    }
//
//    public void update(long id, String login) {
//        JdbcTemplate delete = new JdbcTemplate(dataSource);
//        delete.update("UPDATE USERS SET login = ? where ID= ?",
//                new Object[] { login, id });
//    }

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


//    public void setDataSource(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    @Override
//    public void create(Users user){
//        String sql = "Insert into Users(ID, FIRST_NAME, FAMILY_NAME, E_MAIL, PHONE, LANGUAGE, ID_PICTURE, LOGIN, PASSWORD, BIRTH_DATE, ENABLED) VALUES (:id, :firstName , :familyName, :email, :phone, :language, :pictureId, :login, :password, :birthDate, :enabled)";
//
//        Map parameters = new HashMap();
//        parameters.put("ID", user.getId());
//        parameters.put("FIRST_NAME", user.getFirstName());
//        parameters.put("FAMILY_NAME", user.getFamilyName());
//        parameters.put("E_MAIL", user.getEmail());
//        parameters.put("PHONE", user.getPhone());
//        parameters.put("LANGUAGE", user.getLanguage());
//        parameters.put("ID_PICTURE", user.getPictureId());
//        parameters.put("LOGIN", user.getLogin());
//        parameters.put("PASSWORD", user.getPassword());
//        parameters.put("BIRTH_DATE", user.getBirthDate());
//        parameters.put("ENABLED", user.getEnabled());
//
//        this.namedParameterJdbcTemplate.update(sql, parameters);
//        System.out.println("----------UsersRecord---------");
//    }

    //@Override
//    public Users getUser(long id){
//        String SQL = "SELECT * FROM USERS WHERE id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
//        Users users = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, (RowMapper<Users>) new UserRowMapper());
//        return users;
//    }

   // @Override
//    public List<Users> listUsers(){
//        String SQL = "select * from USERS";
//        List<Users> users = namedParameterJdbcTemplate.query(SQL, (RowMapper<Users>) new UserRowMapper());
//
//        return users;
//    }

//    @Override
//    public void delete(long id){
//        String SQL = "delete from USERS where id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Long.valueOf(id));
//        namedParameterJdbcTemplate.update(SQL,namedParameters);
//        System.out.println("Deleted user with id = " + id);
//    }


//    @Override
//    public void update(long id, String login){
//        String SQL = "update Users set login = :login WHERE id = :id";
//        Map parameters = new HashMap();
//        parameters.put("id",id);
//        parameters.put("login",login);
//
//        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
//        namedParameterJdbcTemplate.update(SQL,namedParameters);
//        System.out.println("Updated user with id = "+ id);
//    }

    @Override
    public Users findByLogin(String login){
        String SQL = "SELECT * FROM USERS WHERE LOGIN = :login";
        SqlParameterSource namedParameters = new MapSqlParameterSource("login",String.valueOf(login));
        Users users = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, (RowMapper<Users>) new UsersRowMapper());
        return users;
    }

    @Override
    public <S extends Users> S save(S s) {
        return null;
    }

    @Override
    public Users findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public List<Users> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Users> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Users users) {

    }

    @Override
    public void delete(Iterable<? extends Users> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable<Users> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Users getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Users> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Users> List<S> save(Iterable<S> iterable) {
        return null;
    }
}
