package com.pei.billinginquiry.insuredbilling.service;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.CurrentTotalPaid;

/**
 * Service Layer for CurrentTotalPaid.
 *
 * @author alfonso.pech
 *
 */
public interface CurrentTotalPaidService {

	/**
	 * @param submissionNumber
	 * @return CurrentTotalPaid
	 */
	List<CurrentTotalPaid> getCurrentTotalPaid(int submissionNumber);

}
