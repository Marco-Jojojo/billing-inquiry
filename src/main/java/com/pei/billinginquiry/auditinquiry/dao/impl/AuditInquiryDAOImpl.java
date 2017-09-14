package com.pei.billinginquiry.auditinquiry.dao.impl;

import com.pei.billinginquiry.auditinquiry.dao.AuditInquiryDAO;
import com.pei.billinginquiry.auditinquiry.dao.rowmappers.AuditInquiryRowMapper;
import com.pei.billinginquiry.auditinquiry.model.AuditInquiry;
import com.pei.billinginquiry.util.StoredProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditInquiryDAOImpl implements AuditInquiryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AuditInquiry> findBySubmission(int submissionNum) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        List<AuditInquiry> inquiries = this.jdbcTemplate.query(
                StoredProcedures.GET_INTERIM_AUDITS ,
                new Object[]{ submissionNum } ,
                new AuditInquiryRowMapper());
        return inquiries;
    }

    @Override
    public List<AuditInquiry> findBySubmissionNumbers(int submissionNum, int submissionNum2) {
        List<AuditInquiry> inquiries = this.jdbcTemplate.query(StoredProcedures.GET_INTERIM_AUDITS_2
                ,new Object[]{submissionNum,submissionNum2},
                new AuditInquiryRowMapper());
        return inquiries;
    }
}
