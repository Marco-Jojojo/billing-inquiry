package com.pei.billinginquiry.dao;

import com.pei.billinginquiry.model.Hello;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@Repository
public class HelloDAOImpl implements HelloDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}

class HelloMapper implements RowMapper<Hello> {
    
    @Override
    public Hello mapRow(ResultSet rs, int i) throws SQLException {
        Hello hello = new Hello(rs.getString(0));
        return hello;
    }
    
}
