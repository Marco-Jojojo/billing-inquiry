package com.pei.billinginquiry.billinginquiry.dao.impl;

import com.pei.billinginquiry.billinginquiry.dao.BillingDataDAO;
import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.util.StoredProcedures;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
@Repository
public class BillingDataDAOImpl implements BillingDataDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<BillingData> getBillingData(String agencyCode, int policyKey) {
        List<BillingData> result = jdbcTemplate.query(StoredProcedures.GET_BILLING_DATA, new Object[]{agencyCode, policyKey}, new BillingDataMapper());
        return result;
    }

}

/**
 * Mapper for Billing Data.
 * @author Marco Alvarado
 */
class BillingDataMapper implements RowMapper<BillingData>
{
    @Override
    public BillingData mapRow(ResultSet rs, int i) throws SQLException {
        BillingData bd = new BillingData();
        bd.setBillingKey(rs.getInt("BillingKey"));
        bd.setDescription(rs.getString("Description"));
        bd.setFromDate(rs.getTimestamp("FromDate"));
        bd.setToDate(rs.getTimestamp("ToDate"));
        bd.setAmount(rs.getDouble("Amount"));
        bd.setDueDate(rs.getTimestamp("DueDate"));
        return bd;
    }
}