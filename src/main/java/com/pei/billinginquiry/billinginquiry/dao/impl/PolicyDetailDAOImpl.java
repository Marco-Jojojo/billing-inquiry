package com.pei.billinginquiry.billinginquiry.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pei.billinginquiry.billinginquiry.dao.PolicyDetailDAO;
import com.pei.billinginquiry.billinginquiry.model.PolicyDetail;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * @author alfonso.pech
 *
 */
@Repository
public class PolicyDetailDAOImpl implements PolicyDetailDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<PolicyDetail> getPolicyDetail(final String agencyCode, final int policyKey) {
		final List<PolicyDetail> result = jdbcTemplate.query(StoredProcedures.GET_POLICY_DETAIL,
				new Object[] { agencyCode, policyKey }, new PolicyDetailMapper());
		return result;
	}

	class PolicyDetailMapper implements RowMapper<PolicyDetail> {
		@Override
		public PolicyDetail mapRow(final ResultSet rs, final int i) throws SQLException {
			final PolicyDetail bd = new PolicyDetail();
			bd.setAddr1(rs.getString("Addr1"));
			bd.setAddr2(rs.getString("addr2"));
			bd.setCalcPending(rs.getString("CalcPending"));
			bd.setCancelDate(rs.getTimestamp("CancelDate"));
			bd.setCity(rs.getString("City"));
			bd.setCustName(rs.getString("CustName"));
			bd.setEffectiveDate(rs.getTimestamp("EffectiveDate"));
			bd.setEstAnnPremium(rs.getInt("EstAnnPremium"));
			bd.setExpirationDate(rs.getTimestamp("ExpirationDate"));
			bd.setFees(rs.getDouble("Fees"));
			bd.setPaymentPlanFrequency(rs.getString("PaymentPlanFrequency"));
			bd.setPaymentPlanType(rs.getString("PaymentPlanType"));
			bd.setPendingAmount(rs.getString("PendingAmount"));
			bd.setPendingApplies(rs.getString("PendingApplies"));
			bd.setPendingDate(rs.getTimestamp("PendingDate"));
			bd.setPolicyKey(rs.getInt("PolicyKey"));
			bd.setPolicyNo(rs.getString("PolicyNo"));
			bd.setState(rs.getString("State"));
			bd.setStatus(rs.getString("Status"));
			bd.setStatusDate(rs.getTimestamp("StatusDate"));
			bd.setUseCancelStatus(rs.getString("UseCancelStatus"));
			bd.setUseReason(rs.getString("UseReason"));
			bd.setUseStatusDate(rs.getString("UseStatusDate"));
			bd.setZip(rs.getInt("Zip"));
			return bd;
		}
	}
}
