package com.pei.billinginquiry.billinginquiry.dao.rowmappers;

import com.pei.billinginquiry.billinginquiry.model.AuditInquiry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditInquiryRowMapper implements RowMapper<AuditInquiry> {
    @Override
    public AuditInquiry mapRow(ResultSet resultSet, int index) throws SQLException {
        AuditInquiry auditInquiry = new AuditInquiry();
        auditInquiry.setSolicitationNumber(resultSet.getString("SOLICITATION_NUMBER") );
        auditInquiry.setBillingPeriodFrom(resultSet.getDate("BILLING_PERIOD_FROM"));
        auditInquiry.setBillingPeriodTo(resultSet.getDate("BILLING_PERIOD_TO"));
        auditInquiry.setBilledIndicatorYN(resultSet.getString("BILLED_INDICATOR_YN"));
        auditInquiry.setSolicitationType(resultSet.getString("SOLICITATION_TYPE"));
        auditInquiry.setPolicyNumber(resultSet.getString("POLICY_NUMBER"));
        auditInquiry.setDueDate(resultSet.getDate("DUE_DATE"));
        auditInquiry.setStatus(resultSet.getString("STATUS"));
        return auditInquiry;
    }
}
