package com.dissertation.project.jdbc.tokenDBMapping;

import com.dissertation.project.jdbc.usersDBMapping.UserResultSetExtractor;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int line) throws SQLException {
        UserResultSetExtractor extractor = new UserResultSetExtractor();
        return extractor.extractData(rs);
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
