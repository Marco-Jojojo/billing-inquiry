package com.pei.billinginquiry.billinginquiry.dao;

import com.pei.billinginquiry.billinginquiry.model.AuditInquiry;

import java.util.List;

public interface AuditInquiryDAO {


    List<AuditInquiry> findBySubmission(int submissionNum);

    List<AuditInquiry> findBySubmissionNumbers(int submissionNum, int submissionNum2);
}
