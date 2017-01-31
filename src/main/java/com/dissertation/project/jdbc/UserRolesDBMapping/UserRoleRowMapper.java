package com.dissertation.project.jdbc.UserRolesDBMapping;

import com.dissertation.project.jdbc.usersDBMapping.UsersResultSetExtractor;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int line) throws SQLException {
        UsersResultSetExtractor extractor = new UsersResultSetExtractor();
        return extractor.extractData(rs);
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
