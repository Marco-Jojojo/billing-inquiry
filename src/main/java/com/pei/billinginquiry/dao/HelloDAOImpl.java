package com.pei.billinginquiry.dao;

import com.pei.billinginquiry.model.Hello;
import com.pei.billinginquiry.util.StoredProcedures;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

    /**
     * Example to use in the first REST WS
     *
     * @return
     */
    @Override
    public Hello getLastPolicy() {
        List<Hello> result = jdbcTemplate.query(StoredProcedures.LAST_POLICY_CREATED, new HelloMapper());
        return result.get(0);
    }
}

class HelloMapper implements RowMapper<Hello>
{

    @Override
    public Hello mapRow(ResultSet rs, int i) throws SQLException {
        Hello hello = new Hello(rs.getString(0));
        return hello;
    }

}
