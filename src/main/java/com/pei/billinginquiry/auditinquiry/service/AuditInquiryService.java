package com.pei.billinginquiry.auditinquiry.service;

import java.util.List;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;

public interface AuditInquiryService {
	/**
	 * find list of {@link AuditInquiry } by submission number
	 *
	 * @param submissionNum
	 *            parameter used in query to locate all audits related to a
	 *            submission.
	 * @return a list of interim inquiries related to a specific submission.
	 */
	List<AuditInquiry> findInterimAuditBySubmission(int submissionNum);

	/**
	 * find a list of {@link AuditInquiry } by submission numbers
	 *
	 * @param submissionNum
	 *            parameter used in query to locate all audits related to a
	 *            submission.
	 * @param submissionNum2
	 *            alternative parameter used in query to locate all audits
	 *            related to a submission.
	 * @return a list of interim inquiries related to submission numbers.
	 */
	List<AuditInquiry> findInterimAuditBySubmissionNumbers(int submissionNum, int submissionNum2);
}
