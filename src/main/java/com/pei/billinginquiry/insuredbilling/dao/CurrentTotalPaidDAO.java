package com.pei.billinginquiry.insuredbilling.dao;

import java.util.List;

import com.pei.billinginquiry.insuredbilling.model.CurrentTotalPaid;

/**
 * DAO layer for CurrentTotalPaid
 * 
 * @author alfonso.pech
 *
 */
public interface CurrentTotalPaidDAO {

	/**
	 * @param submissionNumber
	 * @return CurrentTotalPaid
	 */
	List<CurrentTotalPaid> getCurrentTotalPaid(int submissionNumber);

}
