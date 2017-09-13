package com.pei.billinginquiry.auditinquiry.service;

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

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.auditinquiry.service.impl.AuditInquiryServiceImpl;
import com.pei.billinginquiry.billinginquiry.dao.impl.AuditInquiryDAOImpl;

/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AuditInquiryService.class)
public class AuditInquiryServiceTest {

	private static final Timestamp BILLING_DUE_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_FROM_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_TO_DATE = new Timestamp(System.currentTimeMillis());
	private static final int SUBMISSION_NUM = 1234;
	private static final int SUBMISSION_NUM2 = 456;
	private static final String POLICY_NUMBER = "WKN12345-5";
	private static final String SOLICITATION_NUMBER = "98777";
	private static final String SOLICITATION_TYPE = "A";
	private static final String STATUS = "NEW";

	private AuditInquiryDAOImpl auditInquiryDAOImplMock = PowerMockito.mock(AuditInquiryDAOImpl.class);

	@InjectMocks
	private AuditInquiryServiceImpl auditInquiryServiceImpl;

	@Test
	public void findBySubmissionTest() {

		when(auditInquiryDAOImplMock.findBySubmission(SUBMISSION_NUM)).thenReturn(generateAuditInquiryList());

		List<AuditInquiry> result = auditInquiryServiceImpl.findInterimAuditBySubmission(SUBMISSION_NUM);

		verify(auditInquiryDAOImplMock).findBySubmission(SUBMISSION_NUM);

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

	@Test
	public void findBySubmissionNumbersTest() {

		when(auditInquiryDAOImplMock.findBySubmissionNumbers(SUBMISSION_NUM, SUBMISSION_NUM2))
				.thenReturn(generateAuditInquiryList());

		List<AuditInquiry> result = auditInquiryServiceImpl.findInterimAuditBySubmissionNumbers(SUBMISSION_NUM,
				SUBMISSION_NUM2);

		verify(auditInquiryDAOImplMock).findBySubmissionNumbers(SUBMISSION_NUM, SUBMISSION_NUM2);

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
