package com.pei.billinginquiry.billinginquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.billinginquiry.model.PolicySearch;
import com.pei.billinginquiry.billinginquiry.model.PolicySearchParams;
import com.pei.billinginquiry.billinginquiry.service.PolicySearchService;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@RestController
@RequestMapping("/BillingInquiry")
public class PolicySearchController {

	@Autowired
	private PolicySearchService policySearchService;

	@RequestMapping(value = {
			"/GetPolicySearch**" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PolicySearch> getPolicySearch(@RequestBody final PolicySearchParams policySearchParams) {
		return policySearchService.getPolicySearch(policySearchParams);
	}

}
