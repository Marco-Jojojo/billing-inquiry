package com.pei.billinginquiry.billinginquiry.dao;

import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.util.StoredProcedures;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@Repository
public class FilenetDocDAOImpl implements FilenetDocDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FilenetDoc> getFilenetDocByDateRange(String fromDate, String toDate, String agencyCode) {
        List<FilenetDoc> result = jdbcTemplate.query(StoredProcedures.GET_FILENET_DOC_BY_DATE, new Object[]{fromDate, toDate, agencyCode}, new FilenetDocMapper());
        return result;
    }
}

/**
 * Mapper for Filenet Documents.
 * @author Marco Alvarado
 */
class FilenetDocMapper implements RowMapper<FilenetDoc>
{

    @Override
    public FilenetDoc mapRow(ResultSet rs, int i) throws SQLException {
        FilenetDoc filenetDoc = new FilenetDoc();
        filenetDoc.setPolicyNum(rs.getInt("POLICY_NO"));
        filenetDoc.setDocRemarks(rs.getString("DOC_REMARKS"));
        filenetDoc.setFileDocNum(rs.getString("F_DOCNUMBER"));
        filenetDoc.setDocDate(rs.getTimestamp("DOCUMENT_DATE"));
        filenetDoc.setDocType(rs.getString("DOC_TYPE"));
        filenetDoc.setDba(rs.getString("DBA"));
        filenetDoc.setInsuredName(rs.getString("INSURED_NAME"));
        filenetDoc.setAccountId(rs.getString("ACCOUNT_ID"));
        filenetDoc.setCompanyNum(rs.getString("COMPANY_NO"));
        filenetDoc.setAgencyCode(rs.getInt("AGENCY_NO"));
        filenetDoc.setEffectiveDate(rs.getTimestamp("EFFECTIVE_DATE"));
        filenetDoc.setSubmissionNumber(rs.getInt("SUBMISSION_NO"));
        filenetDoc.setRevision(rs.getInt("REVISION"));
        filenetDoc.setPolicyType(rs.getString("POLICY_TYPE"));
        filenetDoc.setDateReceived(rs.getTimestamp("DATE_RECEIVED"));
        return filenetDoc;
    }

}
