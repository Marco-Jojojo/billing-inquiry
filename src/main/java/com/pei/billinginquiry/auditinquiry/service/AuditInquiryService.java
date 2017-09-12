package com.pei.billinginquiry.auditinquiry.service;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;

import java.util.List;

public interface AuditInquiryService {
    List<AuditInquiry> findInterimAuditBySubmission(int submissionNum);

    List<AuditInquiry> findInterimAuditBySubmissionNumbers(int submissionNum, int submissionNum2);
}
