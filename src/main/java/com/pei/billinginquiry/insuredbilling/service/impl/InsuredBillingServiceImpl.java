package com.pei.billinginquiry.insuredbilling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.billinginquiry.insuredbilling.dao.InsuredBillingDAO;
import com.pei.billinginquiry.insuredbilling.model.InsuredBilling;
import com.pei.billinginquiry.insuredbilling.service.InsuredBillingService;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@Service
public class InsuredBillingServiceImpl implements InsuredBillingService{
	
	@Autowired
	private InsuredBillingDAO insuredBillingDAO;
	
	@Override
	public List<InsuredBilling> getInsuredBilling(int clientId) {
		return insuredBillingDAO.getInsuredBilling(clientId);
	}

}
