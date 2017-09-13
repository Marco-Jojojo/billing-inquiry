package com.pei.billinginquiry.insuredbilling.service;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.PolicyStatus;

/**
 * Service Layer for PolicyStatus.
 * 
 * @author alfonso.pech
 *
 */
public interface PolicyStatusService {

	/**
	 * @param submissionNumber
	 * @return PolicyStatus
	 */
	List<PolicyStatus> getPolicyStatus(int submissionNumber);

}
