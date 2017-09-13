package com.pei.billinginquiry.insuredbilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pei.billinginquiry.insuredbilling.model.CurrentTotalPaid;
import com.pei.billinginquiry.insuredbilling.service.CurrentTotalPaidService;

/**
 * Controller for CurrentTotalPaid.
 *
 * @author alfonso.pech
 *
 */
@RestController
@RequestMapping("/InsuredBilling")
public class CurrentTotalPaidController {

	@Autowired
	private CurrentTotalPaidService currentTotalPaidService;

	/**
	 * @param submissionNumber
	 * @return CurrentTotalPaid
	 */
	@RequestMapping(value = { "/CurrentTotalPaid/{submissionNumber}" }, method = RequestMethod.GET)
	public List<CurrentTotalPaid> getCurrentTotalPaid(@PathVariable final int submissionNumber) {
		return currentTotalPaidService.getCurrentTotalPaid(submissionNumber);
	}

}
