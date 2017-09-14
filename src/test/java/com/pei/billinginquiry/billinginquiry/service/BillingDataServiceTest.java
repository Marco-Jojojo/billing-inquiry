package com.pei.billinginquiry.billinginquiry.service;

import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pei.billinginquiry.billinginquiry.dao.impl.BillingDataDAOImpl;
import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.billinginquiry.model.BillingDataParams;
import com.pei.billinginquiry.billinginquiry.service.impl.BillingDataServiceImpl;


/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(BillingDataServiceImpl.class)
public class BillingDataServiceTest {

	private static final String AGENCY_CODE = "99999";
	private static final int POLICY_KEY = 12345;
	private static final int BILLING_AMOUNT = 10;
	private static final int BILLING_KEY = 100;
	private static final String BILLING_DESC = "billing description";
	private static final Timestamp BILLING_DUE_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_FROM_DATE = new Timestamp(System.currentTimeMillis());
	private static final Timestamp BILLING_TO_DATE = new Timestamp(System.currentTimeMillis());

	private BillingDataDAOImpl billingDataDAOImplMock = PowerMockito.mock(BillingDataDAOImpl.class);
	
	@InjectMocks
	private BillingDataServiceImpl billingDataServiceImpl;
	
	@Test
	public void billingDataServiceTest() {
		BillingDataParams billingDataParams = new BillingDataParams();
		billingDataParams.setAgencyCode(AGENCY_CODE);
		billingDataParams.setPolicyKey(POLICY_KEY);
		
		when(billingDataDAOImplMock.getBillingData(AGENCY_CODE, POLICY_KEY)).
			thenReturn(generateBillingDataList());

		List<BillingData> result = billingDataServiceImpl.getBillingData(billingDataParams);

		verify(billingDataDAOImplMock).getBillingData(AGENCY_CODE, POLICY_KEY);
				
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(BILLING_AMOUNT, result.get(0).getAmount(), 0);
		Assert.assertEquals(BILLING_DESC, result.get(0).getDescription());
		Assert.assertEquals(BILLING_KEY, result.get(0).getBillingKey());
		Assert.assertEquals(BILLING_DUE_DATE, result.get(0).getDueDate());
		Assert.assertEquals(BILLING_FROM_DATE, result.get(0).getFromDate());
		Assert.assertEquals(BILLING_TO_DATE, result.get(0).getToDate());
	}

	/**
	 * Generate a BillingData List object
	 * 
	 * @return
	 */
	private List<BillingData> generateBillingDataList() {
		List<BillingData> billingDataList = new ArrayList<BillingData>();
		BillingData billingData = new BillingData();
		billingData.setAmount(BILLING_AMOUNT);
		billingData.setBillingKey(BILLING_KEY);
		billingData.setDescription(BILLING_DESC);
		billingData.setDueDate(BILLING_DUE_DATE);
		billingData.setFromDate(BILLING_FROM_DATE);
		billingData.setToDate(BILLING_TO_DATE);

		billingDataList.add(billingData);
		return billingDataList;
	}
}