package com.pei.billinginquiry.billinginquiry.dao;

import java.util.List;

import com.pei.billinginquiry.billinginquiry.model.PolicySearch;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public interface PolicySearchDAO {

	List<PolicySearch> getPolicySearch(String query);

}
