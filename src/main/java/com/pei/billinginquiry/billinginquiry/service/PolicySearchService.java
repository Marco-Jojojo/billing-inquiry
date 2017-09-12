package com.pei.billinginquiry.billinginquiry.service;

import java.util.List;

import com.pei.billinginquiry.billinginquiry.model.PolicySearch;
import com.pei.billinginquiry.billinginquiry.model.PolicySearchParams;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public interface PolicySearchService {

	List<PolicySearch> getPolicySearch(PolicySearchParams policySearchParams);

}
