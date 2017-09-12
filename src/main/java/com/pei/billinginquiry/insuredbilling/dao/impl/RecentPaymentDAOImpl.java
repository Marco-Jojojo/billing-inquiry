package com.pei.billinginquiry.insuredbilling.dao.impl;

import com.pei.billinginquiry.insuredbilling.dao.RecentPaymentDAO;
import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
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
 * @date Sep 12, 2017
 */
@Repository
public class RecentPaymentDAOImpl implements RecentPaymentDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<RecentPayment> getRecentPayments(int clientId) {
        List<RecentPayment> result = jdbcTemplate.query(StoredProcedures.GET_RECENT_PAYMENTS, new Object[]{clientId}, new RecentPaymentMapper());
        return result;
    }

}

class RecentPaymentMapper implements RowMapper<RecentPayment> {
    
    @Override
    public RecentPayment mapRow(ResultSet rs, int i) throws SQLException {
        RecentPayment rp = new RecentPayment();
        rp.setPolicyNumber(rs.getString("PolicyNumber"));
        rp.setEntryDate(rs.getTimestamp("EntryDate"));
        rp.setAmount(rs.getDouble("Amount"));
        rp.setCheckNumber(rs.getString("CheckNumber"));
        return rp;
    }
    
}