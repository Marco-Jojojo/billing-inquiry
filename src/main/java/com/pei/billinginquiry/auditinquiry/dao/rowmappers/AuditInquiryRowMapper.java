package com.pei.billinginquiry.auditinquiry.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;

/**
 * maps the audit inquiry from a result set to an object.
 * 
 * @author carlos.acosta
 *
 */
public class AuditInquiryRowMapper implements RowMapper<AuditInquiry> {
	/**
	 * this method overrides mapRow from {@link RowMapper} class
	 */
	@Override
	public AuditInquiry mapRow(final ResultSet resultSet, final int index) throws SQLException {
		final AuditInquiry auditInquiry = new AuditInquiry();
		auditInquiry.setSolicitationNumber(resultSet.getString("SOLICITATION_NUMBER"));
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
