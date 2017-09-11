package com.pei.billinginquiry.billinginquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.billinginquiry.model.PolicyDetail;
import com.pei.billinginquiry.billinginquiry.model.PolicyDetailParams;
import com.pei.billinginquiry.billinginquiry.service.PolicyDetailService;

/**
 * Controller layer for policy Detail
 * 
 * @author alfonso.pech
 *
 */
@RestController
@RequestMapping("/PolicyDetail")
public class PolicyDetailController {

	@Autowired
	private PolicyDetailService policyDetailService;

	/**
	 * @param policyDetailParams
	 * @return policyDetail
	 */
	@RequestMapping(value = {
			"/GetPolicyDetail**" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PolicyDetail> getPoicyDetail(@RequestBody final PolicyDetailParams policyDetailParams) {
		return policyDetailService.getPolicyDetail(policyDetailParams);
	}

}
