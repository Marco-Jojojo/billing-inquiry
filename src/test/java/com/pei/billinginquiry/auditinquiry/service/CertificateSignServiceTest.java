package com.pei.billinginquiry.auditinquiry.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pei.billinginquiry.auditinquiry.service.impl.CertificateSignServiceImpl;

/**
 * 
 * @author Edgar Torres <edgar.torres@softtek.com>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CertificateSignServiceImpl.class)
public class CertificateSignServiceTest {

	@InjectMocks
	private CertificateSignServiceImpl certificateSignServiceImpl;

	@Test
	public void signDataEmpyTest() {
		String result = certificateSignServiceImpl.signData("", "", "", "");
		Assert.assertNull(result);
	}

	@Test
	public void signDataTest() {
		String result = certificateSignServiceImpl.signData("data", "peiaudit.jks", "alias", "pwd");
		Assert.assertNull(result);
	}

}
