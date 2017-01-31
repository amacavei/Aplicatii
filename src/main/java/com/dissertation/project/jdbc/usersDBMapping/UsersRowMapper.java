package com.dissertation.project.jdbc.usersDBMapping;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int line) throws SQLException {
        UsersResultSetExtractor extractor = new UsersResultSetExtractor();
        return extractor.extractData(rs);
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
