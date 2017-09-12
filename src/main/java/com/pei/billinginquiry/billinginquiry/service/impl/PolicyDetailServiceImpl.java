package com.pei.billinginquiry.billinginquiry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.billinginquiry.billinginquiry.dao.PolicyDetailDAO;
import com.pei.billinginquiry.billinginquiry.model.PolicyDetail;
import com.pei.billinginquiry.billinginquiry.model.PolicyDetailParams;
import com.pei.billinginquiry.billinginquiry.service.PolicyDetailService;

/**
 * @author alfonso.pech
 *
 */
@Service
public class PolicyDetailServiceImpl implements PolicyDetailService {

	@Autowired
	private PolicyDetailDAO policyDetailDAO;

	@Override
	public List<PolicyDetail> getPolicyDetail(final PolicyDetailParams policyDetailParams) {
		return policyDetailDAO.getPolicyDetail(policyDetailParams.getAgencyCode(), policyDetailParams.getPolicyKey());
	}

}
