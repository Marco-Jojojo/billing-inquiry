package com.pei.billinginquiry.billinginquiry.service;

import com.pei.billinginquiry.billinginquiry.model.AuditInquiry;

import java.util.List;

public interface AuditInquiryService {
    List<AuditInquiry> findInterimAuditBySubmission(int submissionNum);

    List<AuditInquiry> findInterimAuditBySubmissionNumbers(int submissionNum, int submissionNum2);
}
