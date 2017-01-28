package com.dissertation.project.jdbc.usersDBMapping;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setId(rs.getLong("Id"));
        user.setFirstName(rs.getString("FirstName"));
        user.setFamilyName(rs.getString("FamilyName"));
        user.setEmail(rs.getString("Email"));
        user.setPhone(rs.getString("Phone"));
        user.setLanguage(rs.getString("Language"));
        user.setPictureId(rs.getString("PictureID"));
        user.setLogin(rs.getString("Login"));
        user.setPassword(rs.getString("Password"));
        user.setBirthDate(rs.getDate("BirthDate"));
        user.setEnabled(rs.getBoolean("Enabled"));
        return user;
    }
}
