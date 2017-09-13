package com.pei.billinginquiry.insuredbilling.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pei.billinginquiry.insuredbilling.dao.CurrentTotalPaidDAO;
import com.pei.billinginquiry.insuredbilling.model.CurrentTotalPaid;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * @author alfonso.pech
 *
 */
public class CurrentTotalPaidDAOImpl implements CurrentTotalPaidDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CurrentTotalPaid> getCurrentTotalPaid(final int submissionNumber) {
		final List<CurrentTotalPaid> result = jdbcTemplate.query(StoredProcedures.GET_CURRENT_TOTAL_PAID,
				new Object[] { submissionNumber }, new CurrentTotalPaidMapper());
		return result;
	}

}

class CurrentTotalPaidMapper implements RowMapper<CurrentTotalPaid> {

	@Override
	public CurrentTotalPaid mapRow(final ResultSet rs, final int i) throws SQLException {
		final CurrentTotalPaid tp = new CurrentTotalPaid();
		tp.setSubmissionNumber(rs.getInt("Submission_Number"));
		tp.setTotalPaid(rs.getDouble("Totalpaid"));
		return tp;
	}
}
