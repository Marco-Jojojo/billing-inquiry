package com.pei.billinginquiry.insuredbilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.insuredbilling.model.InsuredBilling;
import com.pei.billinginquiry.insuredbilling.service.InsuredBillingService;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@RestController
@RequestMapping("/InsuredBilling")
public class InsuredBillingController {
	
	@Autowired
	private InsuredBillingService insuredBillingService;
	
	@RequestMapping(value = {"/InsuredBilling/{clientId}"}, method = RequestMethod.GET)
	public List<InsuredBilling> getInsuredBilling(@PathVariable int clientId){
		return insuredBillingService.getInsuredBilling(clientId);
	}
}
