package com.pei.billinginquiry.billinginquiry.service;

import java.util.List;

import com.pei.billinginquiry.billinginquiry.model.PolicyDetail;
import com.pei.billinginquiry.billinginquiry.model.PolicyDetailParams;

/**
 * @author alfonso.pech
 *
 */
public interface PolicyDetailService {

	/**
	 * @param policyDetailParams
	 * @return policyDetail
	 */
	List<PolicyDetail> getPolicyDetail(PolicyDetailParams policyDetailParams);
}
