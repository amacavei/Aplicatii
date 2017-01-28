package com.dissertation.project.jdbc.UserRolesDBMapping;

import com.dissertation.project.jdbc.rolesDBMapping.Roles;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        UserRoles userRoles = new UserRoles();
        userRoles.setId(rs.getLong("Id"));
        userRoles.setId_user(rs.getLong("Id_user"));
        userRoles.setId_role(rs.getLong("Id_role"));
        return userRoles;
    }
}
