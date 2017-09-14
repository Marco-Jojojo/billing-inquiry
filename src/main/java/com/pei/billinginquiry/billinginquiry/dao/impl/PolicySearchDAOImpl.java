package com.pei.billinginquiry.billinginquiry.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pei.billinginquiry.billinginquiry.dao.PolicySearchDAO;
import com.pei.billinginquiry.billinginquiry.model.PolicySearch;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@Repository
public class PolicySearchDAOImpl implements PolicySearchDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<PolicySearch> getPolicySearch(final String query) {
		final List<PolicySearch> result = jdbcTemplate.query(query, new PolicySearchMapper());
		return result;
	}

}

class PolicySearchMapper implements RowMapper<PolicySearch> {

	@Override
	public PolicySearch mapRow(final ResultSet rs, final int i) throws SQLException {
		final PolicySearch ps = new PolicySearch();
		ps.setPolicyKey(rs.getInt("PolicyKey"));
		ps.setCustName(rs.getString("CustName"));
		ps.setPolicyNo(rs.getString("PolicyNo"));
		ps.setEffectiveDate(rs.getTimestamp("EffectiveDate"));
		ps.setExpirationDate(rs.getTimestamp("ExpirationDate"));
		ps.setAddr1(rs.getString("Addr1"));
		ps.setAddr2(rs.getString("Addr2"));
		ps.setCity(rs.getString("City"));
		ps.setState(rs.getString("State"));
		ps.setStatus(rs.getString("Status"));
		return ps;
	}

}
