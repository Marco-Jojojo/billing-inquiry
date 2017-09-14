package com.pei.billinginquiry.insuredbilling.dao;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.InsuredBilling;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public interface InsuredBillingDAO {
	
	List<InsuredBilling> getInsuredBilling(int clientId);

}
