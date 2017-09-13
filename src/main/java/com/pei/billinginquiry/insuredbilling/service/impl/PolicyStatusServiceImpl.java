package com.pei.billinginquiry.insuredbilling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pei.billinginquiry.insuredbilling.dao.PolicyStatusDAO;
import com.pei.billinginquiry.insuredbilling.model.PolicyStatus;
import com.pei.billinginquiry.insuredbilling.service.PolicyStatusService;

/**
 * @author alfonso.pech
 *
 */
public class PolicyStatusServiceImpl implements PolicyStatusService {

	@Autowired
	private PolicyStatusDAO policyStatusDAO;

	@Override
	public List<PolicyStatus> getPolicyStatus(final int submissionNumber) {
		return policyStatusDAO.getPolicyStatus(submissionNumber);
	}

}
