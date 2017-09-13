package com.pei.billinginquiry.billinginquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.billinginquiry.model.BillingDataParams;
import com.pei.billinginquiry.billinginquiry.service.BillingDataService;

/**
 * Controller layer for Billing Data.
 *
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
@RestController
@RequestMapping("/BillingInquiry")
public class BillingDataController {
	@Autowired
	private BillingDataService billingDataService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getBillingData() {
		return "text";
	}

	/**
	 * Exposes Web Service in http://host:8080/BillingInquiry/GetBillingData
	 * which receives the BillingDataParams parameters: agencyCode and
	 * policyKey.
	 *
	 * @param billingDataParams
	 *            BillingDataParams parameters: agencyCode and policyKey.
	 * @return JSON list of BillingData.
	 */
	@RequestMapping(value = {
	        "/GetBillingData**" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<BillingData> getBillingData(@RequestBody final BillingDataParams billingDataParams) {
		return billingDataService.getBillingData(billingDataParams);
	}
}
