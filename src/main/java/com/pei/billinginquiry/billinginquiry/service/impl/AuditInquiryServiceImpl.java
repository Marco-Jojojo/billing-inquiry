package com.pei.billinginquiry.billinginquiry.service.impl;

import com.pei.billinginquiry.billinginquiry.dao.AuditInquiryDAO;
import com.pei.billinginquiry.billinginquiry.model.AuditInquiry;
import com.pei.billinginquiry.billinginquiry.service.AuditInquiryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditInquiryServiceImpl implements AuditInquiryService {

    private AuditInquiryDAO auditInquiryDAO;

    @Override
    public List<AuditInquiry> findInterimAuditBySubmission(int submissionNum) {
        return this.auditInquiryDAO.findBySubmission(submissionNum);
    }

    @Override
    public List<AuditInquiry> findInterimAuditBySubmissionNumbers(int submissionNum, int submissionNum2) {
        return this.auditInquiryDAO.findBySubmissionNumbers(submissionNum,  submissionNum2);
    }
}
