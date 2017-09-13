package com.pei.billinginquiry.insuredbilling.service;

import static org.junit.Assert.*;
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

import com.pei.billinginquiry.billinginquiry.dao.impl.BillingDataDAOImpl;
import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.billinginquiry.model.BillingDataParams;
import com.pei.billinginquiry.billinginquiry.service.impl.BillingDataServiceImpl;
import com.pei.billinginquiry.insuredbilling.dao.impl.InsuredAuditDAOImpl;
import com.pei.billinginquiry.insuredbilling.model.InsuredAudit;
import com.pei.billinginquiry.insuredbilling.service.impl.InsuredAuditServiceImpl;

/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(InsuredAuditServiceImpl.class)
public class InsuredAuditServiceTest {

	private static final int CLIENT_ID = 1234;
	private static final String AUDIT_COMMENT = null;
	private static final String AUDIT_TYPE = null;
	private static final String POLICY_NUMBER = null;
	private static final String SOLICITATION_NUMBER = null;
	private static final Timestamp BILLING_DUE_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_FROM_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_TO_DATE = new Timestamp(System.currentTimeMillis());

	private InsuredAuditDAOImpl insuredAuditDAOImplMock = PowerMockito.mock(InsuredAuditDAOImpl.class);
	
	@InjectMocks
	private InsuredAuditServiceImpl insuredAuditServiceImpl;
	
	@Test
	public void billingDataServiceTest() {
		
		when(insuredAuditDAOImplMock.getInsuredAudit(CLIENT_ID)).thenReturn(generateInsuredAuditList());

		List<InsuredAudit> result = insuredAuditServiceImpl.getInsuredAudit(CLIENT_ID);

		verify(insuredAuditDAOImplMock).getInsuredAudit(CLIENT_ID);
				
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(AUDIT_COMMENT, result.get(0).getAuditComment());
		Assert.assertEquals(AUDIT_TYPE, result.get(0).getAuditType());
		Assert.assertEquals(POLICY_NUMBER, result.get(0).getPolicyNumber());
		Assert.assertEquals(SOLICITATION_NUMBER, result.get(0).getSolicitationNumber());
		Assert.assertEquals(BILLING_DUE_DATE, result.get(0).getDueDate());
		Assert.assertEquals(BILLING_FROM_DATE, result.get(0).getBillingPeriodFrom());
		Assert.assertEquals(BILLING_TO_DATE, result.get(0).getBillingPeriodTo());
	}

	/**
	 * Generate a InsuredAudit List object
	 * 
	 * @return
	 */
	private List<InsuredAudit> generateInsuredAuditList() {
		List<InsuredAudit> insuredAuditList = new ArrayList<InsuredAudit>();
		InsuredAudit insuredAudit = new InsuredAudit();
		insuredAudit.setAuditComment(AUDIT_COMMENT);;
		insuredAudit.setAuditType(AUDIT_TYPE);
		insuredAudit.setBillingPeriodFrom(BILLING_FROM_DATE);
		insuredAudit.setDueDate(BILLING_DUE_DATE);
		insuredAudit.setBillingPeriodTo(BILLING_TO_DATE);
		insuredAudit.setPolicyNumber(POLICY_NUMBER);
		insuredAudit.setSolicitationNumber(SOLICITATION_NUMBER);

		insuredAuditList.add(insuredAudit);
		return insuredAuditList;
	}

}
