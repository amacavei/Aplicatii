package com.dissertation.project.jdbc.rolesDBMapping;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        Roles role = new Roles();
        role.setId(rs.getLong("Id"));
        role.setName(rs.getString("Name"));
        return role;
    }
}
