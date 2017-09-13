package com.pei.billinginquiry.auditinquiry.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pei.billinginquiry.auditinquiry.dao.AuditInquiryDAO;
import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.auditinquiry.service.AuditInquiryService;

@Service
public class AuditInquiryServiceImpl implements AuditInquiryService {
	private AuditInquiryDAO auditInquiryDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AuditInquiry> findInterimAuditBySubmission(final int submissionNum) {
		return this.auditInquiryDAO.findBySubmission(submissionNum);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AuditInquiry> findInterimAuditBySubmissionNumbers(final int submissionNum, final int submissionNum2) {
		return this.auditInquiryDAO.findBySubmissionNumbers(submissionNum, submissionNum2);
	}
}
