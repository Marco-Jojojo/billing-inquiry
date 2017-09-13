package com.pei.billinginquiry.insuredbilling.dao;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.PolicyStatus;

/**
 * DAO layer for PolicyStatus
 *
 * @author alfonso.pech
 *
 */
public interface PolicyStatusDAO {

	/**
	 * @param submissionNumber
	 * @return PolicyStatus
	 */
	List<PolicyStatus> getPolicyStatus(int submissionNumber);

}
