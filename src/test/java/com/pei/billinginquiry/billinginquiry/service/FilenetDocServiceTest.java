package com.pei.billinginquiry.billinginquiry.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.pei.billinginquiry.billinginquiry.dao.impl.FilenetDocDAOImpl;
import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.billinginquiry.model.FilenetDocParams;
import com.pei.billinginquiry.billinginquiry.service.impl.FilenetDocServiceImpl;


/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FilenetDocServiceImpl.class)
public class FilenetDocServiceTest {

	private static final String S_AGENCY_CODE = "9999";
	private static final String ACCOUNT_ID = "101101";
	private static final String FROM_DATE = "01-01-2017";
	private static final String TO_DATE = "12-01-2017";
	private static final String COMPANY_NUM = "100";
	private static final int AGENCY_CODE = 9999;
	private FilenetDocDAOImpl filenetDocDAOImplMock = PowerMockito.mock(FilenetDocDAOImpl.class);

	@InjectMocks
	private FilenetDocServiceImpl filenetDocServiceImpl;

	@Test
	public void testGetBillingData() {
		FilenetDocParams filenetDocParams = new FilenetDocParams();
		filenetDocParams.setAgencyCode(S_AGENCY_CODE);
		filenetDocParams.setFromDate(FROM_DATE);
		filenetDocParams.setToDate(TO_DATE);
		
		when(filenetDocDAOImplMock.getFilenetDocByDateRange(FROM_DATE, TO_DATE, S_AGENCY_CODE))
				.thenReturn(generateBillingDataList());

		List<FilenetDoc> result = filenetDocServiceImpl.getFilenetDocByDateRange(filenetDocParams);

		verify(filenetDocDAOImplMock).getFilenetDocByDateRange(FROM_DATE, TO_DATE, S_AGENCY_CODE);

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
