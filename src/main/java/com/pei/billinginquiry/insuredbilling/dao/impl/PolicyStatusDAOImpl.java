package com.pei.billinginquiry.insuredbilling.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pei.billinginquiry.insuredbilling.dao.PolicyStatusDAO;
import com.pei.billinginquiry.insuredbilling.model.PolicyStatus;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * @author alfonso.pech
 *
 */
@Repository
public class PolicyStatusDAOImpl implements PolicyStatusDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<PolicyStatus> getPolicyStatus(final int submissionNumber) {
		final List<PolicyStatus> result = jdbcTemplate.query(StoredProcedures.GET_POLICY_STATUS,
				new Object[] { submissionNumber }, new PolicyStatusMapper());
		return result;
	}

}

class PolicyStatusMapper implements RowMapper<PolicyStatus> {

	@Override
	public PolicyStatus mapRow(final ResultSet rs, final int i) throws SQLException {
		final PolicyStatus ps = new PolicyStatus();
		ps.setSubmissionNumber(rs.getInt("Submission_Number"));
		ps.setEffectiveDate(rs.getTimestamp("EffectiveDate"));
		ps.setExpirationDate(rs.getTimestamp("ExpirationDate"));
		ps.setEstAnnualPremium(rs.getInt("EstAnnualPremium"));
		ps.setFees(rs.getDouble("Fees"));
		ps.setBillFrequency(rs.getString("BillFrequency"));
		ps.setBillType(rs.getString("BillType"));
		ps.setStatus(rs.getString("Status"));
		ps.setReason(rs.getString("Reason"));
		ps.setCancelDate(rs.getTimestamp("CancelDate"));
		ps.setCancelPremiumDue(rs.getDouble("CancelPremiumDue"));
		return ps;
	}
}