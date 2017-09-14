package com.pei.billinginquiry.insuredbilling.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pei.billinginquiry.insuredbilling.dao.InsuredBillingDAO;
import com.pei.billinginquiry.insuredbilling.model.InsuredBilling;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@Repository
public class InsuredBillingDAOImpl implements InsuredBillingDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<InsuredBilling> getInsuredBilling(int clientId) {
		List<InsuredBilling> result = jdbcTemplate.query(StoredProcedures.GET_INSURED_BILLING, new Object[]{clientId}, new InsuredBillingMapper());
		return result;
	}

}

class InsuredBillingMapper implements RowMapper<InsuredBilling>{

	@Override
	public InsuredBilling mapRow(ResultSet rs, int i) throws SQLException {
		InsuredBilling ib = new InsuredBilling();
		ib.setPolicyNumber(rs.getString("PolicyNumber"));
		ib.setBillingKey(rs.getString("BillingKey"));
		ib.setTransactionDesc(rs.getString("TransactionDesc"));
		ib.setFromDate(rs.getTimestamp("FromDate"));
		ib.setToDate(rs.getTimestamp("ToDate"));
		ib.setAmount(rs.getDouble("Amount"));
		ib.setDueDate(rs.getTimestamp("DueDate"));
		return ib;
	}
	
}
