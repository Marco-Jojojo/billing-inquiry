package com.pei.billinginquiry.auditinquiry.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.pei.billinginquiry.auditinquiry.dao.rowmappers.AuditInquiryRowMapper;
import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.auditinquiry.dao.impl.AuditInquiryDAOImpl;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AuditInquiryDAOImpl.class)
public class AuditInquiryDAOTest {

	private static final Timestamp BILLING_DUE_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_FROM_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_TO_DATE = new Timestamp(System.currentTimeMillis());
	private static final int SUBMISSION_NUM = 1234;
	private static final int SUBMISSION_NUM2 = 456;
	private static final String POLICY_NUMBER = "WKN12345-5";
	private static final String SOLICITATION_NUMBER = "98777";
	private static final String SOLICITATION_TYPE = "A";
	private static final String STATUS = "NEW";
	private NamedParameterJdbcTemplate jdbcTemplateMock = PowerMockito.mock(NamedParameterJdbcTemplate.class);

	@InjectMocks
	private AuditInquiryDAOImpl auditInquiryDAOImplMock;

	@SuppressWarnings("unchecked")
	@Test
	public void findBySubmissionTest() {

		when(jdbcTemplateMock.query(eq(StoredProcedures.GET_INTERIM_AUDITS), any(MapSqlParameterSource.class),
				any(RowMapper.class))).thenReturn(generateAuditInquiryList());

		List<AuditInquiry> result = auditInquiryDAOImplMock.findBySubmission(SUBMISSION_NUM);

		verify(jdbcTemplateMock).query(eq(StoredProcedures.GET_INTERIM_AUDITS), any(MapSqlParameterSource.class),
				any(AuditInquiryRowMapper.class));

		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(POLICY_NUMBER, result.get(0).getPolicyNumber());
		Assert.assertEquals(SOLICITATION_NUMBER, result.get(0).getSolicitationNumber());
		Assert.assertEquals(SOLICITATION_TYPE, result.get(0).getSolicitationType());
		Assert.assertEquals(BILLING_DUE_DATE, result.get(0).getDueDate());
		Assert.assertEquals(BILLING_FROM_DATE, result.get(0).getBillingPeriodFrom());
		Assert.assertEquals(BILLING_TO_DATE, result.get(0).getBillingPeriodTo());
		Assert.assertEquals(STATUS, result.get(0).getStatus());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void findBySubmissionNumbersTest() {

		when(jdbcTemplateMock.query(eq(StoredProcedures.GET_INTERIM_AUDITS_2), any(MapSqlParameterSource.class),
				any(RowMapper.class))).thenReturn(generateAuditInquiryList());

		List<AuditInquiry> result = auditInquiryDAOImplMock.findBySubmissionNumbers(SUBMISSION_NUM, SUBMISSION_NUM2);

		verify(jdbcTemplateMock).query(eq(StoredProcedures.GET_INTERIM_AUDITS_2), any(MapSqlParameterSource.class),
				any(AuditInquiryRowMapper.class));

		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(POLICY_NUMBER, result.get(0).getPolicyNumber());
		Assert.assertEquals(SOLICITATION_NUMBER, result.get(0).getSolicitationNumber());
		Assert.assertEquals(SOLICITATION_TYPE, result.get(0).getSolicitationType());
		Assert.assertEquals(BILLING_DUE_DATE, result.get(0).getDueDate());
		Assert.assertEquals(BILLING_FROM_DATE, result.get(0).getBillingPeriodFrom());
		Assert.assertEquals(BILLING_TO_DATE, result.get(0).getBillingPeriodTo());
		Assert.assertEquals(STATUS, result.get(0).getStatus());
	}

	/**
	 * Generate an AuditInquiry List object
	 * 
	 * @return
	 */
	private List<AuditInquiry> generateAuditInquiryList() {
		List<AuditInquiry> auditInquiryList = new ArrayList<AuditInquiry>();
		AuditInquiry auditInquiry = new AuditInquiry();
		auditInquiry.setPolicyNumber(POLICY_NUMBER);
		auditInquiry.setBillingPeriodFrom(BILLING_FROM_DATE);
		auditInquiry.setBillingPeriodTo(BILLING_TO_DATE);
		auditInquiry.setDueDate(BILLING_DUE_DATE);
		auditInquiry.setSolicitationNumber(SOLICITATION_NUMBER);
		auditInquiry.setSolicitationType(SOLICITATION_TYPE);
		auditInquiry.setStatus(STATUS);
		auditInquiryList.add(auditInquiry);
		return auditInquiryList;
	}
}
