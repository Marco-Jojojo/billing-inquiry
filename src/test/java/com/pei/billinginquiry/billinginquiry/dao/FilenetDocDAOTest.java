package com.pei.billinginquiry.billinginquiry.dao;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pei.billinginquiry.billinginquiry.dao.impl.FilenetDocDAOImpl;
import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.util.StoredProcedures;

/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FilenetDocDAOImpl.class)
public class FilenetDocDAOTest {
	
	private static final int AGENCY_CODE = 99999;
	private static final String ACCOUNT_ID = "101101";
	private static final String FROM_DATE = "01-01-2017";
	private static final String TO_DATE = "12-01-2017";
	private static final String COMPANY_NUM = "100";
	private JdbcTemplate jdbcTemplateMock = PowerMockito.mock(JdbcTemplate.class);
	
	@InjectMocks
	private FilenetDocDAOImpl filenetDocDAOImpl;

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testGetBillingData() {
		when(jdbcTemplateMock.query(eq(StoredProcedures.GET_FILENET_DOC_BY_DATE), 
				eq(new Object[]{FROM_DATE, TO_DATE, "99999"}), 
				any(RowMapper.class))).thenReturn(generateBillingDataList());

		List<FilenetDoc> result = filenetDocDAOImpl.getFilenetDocByDateRange(FROM_DATE, TO_DATE, "99999");

		verify(jdbcTemplateMock).query(eq(StoredProcedures.GET_FILENET_DOC_BY_DATE), 
				eq(new Object[]{FROM_DATE, TO_DATE, "99999" }),
				any(RowMapper.class));
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(AGENCY_CODE, result.get(0).getAgencyCode());
		Assert.assertEquals(ACCOUNT_ID, result.get(0).getAccountId());
		Assert.assertEquals(COMPANY_NUM, result.get(0).getCompanyNum());
	}

	/**
	 * Generate a FilenetDoc List object
	 * 
	 * @return
	 */
	private List<FilenetDoc> generateBillingDataList() {
		List<FilenetDoc> filenetDocList = new ArrayList<FilenetDoc>();
		FilenetDoc filenetDoc = new FilenetDoc();
		filenetDoc.setAccountId(ACCOUNT_ID);
		filenetDoc.setAgencyCode(AGENCY_CODE);
		filenetDoc.setCompanyNum(COMPANY_NUM);

		filenetDocList.add(filenetDoc);
		return filenetDocList;
	}

}
