package com.pei.billinginquiry.auditinquiry.dao;

import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;

import java.util.List;

public interface AuditInquiryDAO {


    List<AuditInquiry> findBySubmission(int submissionNum);

    List<AuditInquiry> findBySubmissionNumbers(int submissionNum, int submissionNum2);
}
