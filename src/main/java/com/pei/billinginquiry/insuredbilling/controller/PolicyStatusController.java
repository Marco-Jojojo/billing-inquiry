package com.pei.billinginquiry.insuredbilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.insuredbilling.model.PolicyStatus;
import com.pei.billinginquiry.insuredbilling.service.PolicyStatusService;

/**
 * @author alfonso.pech
 *
 */
@RestController
@RequestMapping("/InsuredBilling")
public class PolicyStatusController {

	@Autowired
	PolicyStatusService policyStatusService;

	/**
	 * @param submissionNumber
	 * @return PolicyStatus
	 */
	@RequestMapping(value = { "/PolicyStatus/{submissionNumber}" }, method = RequestMethod.GET)
	public List<PolicyStatus> getPolicyStatus(@PathVariable final int submissionNumber) {
		return policyStatusService.getPolicyStatus(submissionNumber);
	}

}
