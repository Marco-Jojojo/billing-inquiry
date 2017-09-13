package com.pei.billinginquiry.auditinquiry.dao.impl;

import com.pei.billinginquiry.auditinquiry.dao.AuditInquiryDAO;
import com.pei.billinginquiry.auditinquiry.dao.rowmappers.AuditInquiryRowMapper;
import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.util.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditInquiryDAOImpl implements AuditInquiryDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<AuditInquiry> findBySubmission(int submissionNum) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        List<AuditInquiry> inquiries = this.namedParameterJdbcTemplate.query(
                StoredProcedures.GET_INTERIM_AUDITS ,
                parameters ,
                new AuditInquiryRowMapper());
        return inquiries;
    }

    @Override
    public List<AuditInquiry> findBySubmissionNumbers(int submissionNum, int submissionNum2) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("SubmissionNumber",submissionNum);
        parameters.addValue("SubmissionNumber2",submissionNum);
        List<AuditInquiry> inquiries = this.namedParameterJdbcTemplate.query(StoredProcedures.GET_INTERIM_AUDITS_2
                ,parameters,
                new AuditInquiryRowMapper());
        return inquiries;
    }
}
