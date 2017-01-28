package com.dissertation.project.jdbc.tokenDBMapping;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        Tokens token = new Tokens();
        token.setSeries(rs.getString("series"));
        token.setValue(rs.getString("value"));
        token.setDate(rs.getDate("date"));
        token.setIpAddress(rs.getString("ipAddress"));
        token.setUserAgent(rs.getString("userAgent"));
        token.setUserLogin(rs.getString("userLogin"));
        return token;
    }
}
