package com.pei.billinginquiry.insuredbilling.dao;

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pei.billinginquiry.insuredbilling.dao.impl.RecentPaymentDAOImpl;
import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
import com.pei.billinginquiry.util.StoredProcedures;
/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(RecentPaymentDAOImpl.class)
public class RecentPaymentDAOTest {

	private static final int BILLING_AMOUNT = 100;
	private static final int CLIENT_ID = 7878;
	private static final String CHECK_NUMBER = "4574576";
	private static final String POLICY_NUMBER = "WKN237864-1";
	private static final Timestamp ENTRY_DATE = new Timestamp(System.currentTimeMillis());
	private JdbcTemplate jdbcTemplateMock = PowerMockito.mock(JdbcTemplate.class);

	@InjectMocks 
	private RecentPaymentDAOImpl recentPaymentDAOImpl;

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testGetBillingData() {
		when(jdbcTemplateMock.query(eq(StoredProcedures.GET_RECENT_PAYMENTS), 
				eq(new Object[]{CLIENT_ID }), 
				any(RowMapper.class))).thenReturn(generateRecentPaymentList());

		List<RecentPayment> result = recentPaymentDAOImpl.getRecentPayments(CLIENT_ID);

		verify(jdbcTemplateMock).query(eq(StoredProcedures.GET_RECENT_PAYMENTS), 
				eq(new Object[]{CLIENT_ID }),
				any(RowMapper.class));
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(BILLING_AMOUNT, result.get(0).getAmount(), 0);
		Assert.assertEquals(CHECK_NUMBER, result.get(0).getCheckNumber());
		Assert.assertEquals(ENTRY_DATE, result.get(0).getEntryDate());
		Assert.assertEquals(POLICY_NUMBER, result.get(0).getPolicyNumber());
	}

	/**
	 * Generate a RecentPayment List object
	 * 
	 * @return
	 */
	private List<RecentPayment> generateRecentPaymentList() {
		List<RecentPayment> recentPaymentList = new ArrayList<RecentPayment>();
		RecentPayment recentPayment = new RecentPayment();
		recentPayment.setAmount(BILLING_AMOUNT);
		recentPayment.setCheckNumber(CHECK_NUMBER);
		recentPayment.setPolicyNumber(POLICY_NUMBER);
		recentPayment.setEntryDate(ENTRY_DATE);


		recentPaymentList.add(recentPayment);
		return recentPaymentList;
	}
}
