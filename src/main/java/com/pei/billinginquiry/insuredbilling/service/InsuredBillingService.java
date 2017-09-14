package com.pei.billinginquiry.insuredbilling.service;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.InsuredBilling;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public interface InsuredBillingService {
	
	List<InsuredBilling> getInsuredBilling(int clientId);

}
