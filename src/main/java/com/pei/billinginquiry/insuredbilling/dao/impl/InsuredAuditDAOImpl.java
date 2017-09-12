package com.pei.billinginquiry.insuredbilling.dao.impl;

import com.pei.billinginquiry.insuredbilling.dao.InsuredAuditDAO;
import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
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
public class InsuredAuditDAOImpl implements InsuredAuditDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<InsuredAudit> getInsuredAudit(int clientId) {
        List<InsuredAudit> result = jdbcTemplate.query(StoredProcedures.GET_INSURED_AUDIT, new Object[]{clientId}, new InsuredAuditMapper());
        return result;
    }

}

class InsuredAuditMapper implements RowMapper<InsuredAudit> {
    
    @Override
    public InsuredAudit mapRow(ResultSet rs, int i) throws SQLException {
        InsuredAudit ia = new InsuredAudit();
        ia.setPolicyNumber(rs.getString("PolicyNumber"));
        ia.setSolicitationNumber(rs.getString("SolicitationNumber"));
        ia.setAuditType(rs.getString("AuditType"));
        ia.setBillingPeriodFrom(rs.getTimestamp("Billing_Period_From"));
        ia.setBillingPeriodTo(rs.getTimestamp("Billing_Period_To"));
        ia.setDueDate(rs.getTimestamp("DueDate"));
        ia.setDateReceived(rs.getTimestamp("DATE_RECEIVED"));
        ia.setAuditComment(rs.getString("AuditComment"));
        return ia;
    }
    
}