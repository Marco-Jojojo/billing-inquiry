package com.pei.billinginquiry.insuredbilling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.billinginquiry.insuredbilling.dao.CurrentTotalPaidDAO;
import com.pei.billinginquiry.insuredbilling.model.CurrentTotalPaid;
import com.pei.billinginquiry.insuredbilling.service.CurrentTotalPaidService;

/**
 * @author alfonso.pech
 *
 */
@Service
public class CurrentTotalPaidServiceImpl implements CurrentTotalPaidService {

	@Autowired
	private CurrentTotalPaidDAO currentTotalPaidDAO;

	@Override
	public List<CurrentTotalPaid> getCurrentTotalPaid(final int submissionNumber) {
		return currentTotalPaidDAO.getCurrentTotalPaid(submissionNumber);
	}

}
