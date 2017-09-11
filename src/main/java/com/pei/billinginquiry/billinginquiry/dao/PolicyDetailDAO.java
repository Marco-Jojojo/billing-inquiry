package com.pei.billinginquiry.billinginquiry.dao;

import java.util.List;

import com.pei.billinginquiry.billinginquiry.model.PolicyDetail;

/**
 * @author alfonso.pech
 *
 */
public interface PolicyDetailDAO {

	/**
	 * @param agencyCode
	 * @param policyKey
	 * @return PolicyDetail
	 */
	List<PolicyDetail> getPolicyDetail(String agencyCode, int policyKey);

}
