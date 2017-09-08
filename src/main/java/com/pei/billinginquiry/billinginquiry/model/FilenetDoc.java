package com.pei.billinginquiry.billinginquiry.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Model for Filenet documents.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class FilenetDoc implements Serializable
{
    private static final long serialVersionUID = 3656663293974553896L;
    
    private int policyNum;
    private String docRemarks;
    private String fileDocNum;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp docDate;
    private String docType;
    private String dba;
    private String insuredName;
    private String accountId;
    private String companyNum;
    private int agencyCode;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp effectiveDate;
    private int submissionNumber;
    private int revision;
    private String policyType;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp dateReceived;

    @JsonProperty("POLICY_NO")
    public int getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(int policyNum) {
        this.policyNum = policyNum;
    }

    @JsonProperty("DOC_REMARKS")
    public String getDocRemarks() {
        return docRemarks;
    }

    public void setDocRemarks(String docRemarks) {
        this.docRemarks = docRemarks;
    }

    @JsonProperty("F_DOCNUMBER")
    public String getFileDocNum() {
        return fileDocNum;
    }

    public void setFileDocNum(String fileDocNum) {
        this.fileDocNum = fileDocNum;
    }

    @JsonProperty("DOCUMENT_DATE")
    public Timestamp getDocDate() {
        return docDate;
    }

    public void setDocDate(Timestamp docDate) {
        this.docDate = docDate;
    }

    @JsonProperty("DOC_TYPE")
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @JsonProperty("DBA")
    public String getDba() {
        return dba;
    }

    public void setDba(String dba) {
        this.dba = dba;
    }

    @JsonProperty("INSURED_NAME")
    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    @JsonProperty("ACCOUNT_ID")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("COMPANY_NO")
    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    @JsonProperty("AGENCY_NO")
    public int getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(int agencyCode) {
        this.agencyCode = agencyCode;
    }

    @JsonProperty("EFFECTIVE_DATE")
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @JsonProperty("SUBMISSION_NO")
    public int getSubmissionNumber() {
        return submissionNumber;
    }

    public void setSubmissionNumber(int submissionNumber) {
        this.submissionNumber = submissionNumber;
    }

    @JsonProperty("REVISION")
    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @JsonProperty("POLICY_TYPE")
    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @JsonProperty("DATE_RECEIVED")
    public Timestamp getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Timestamp dateReceived) {
        this.dateReceived = dateReceived;
    }
    
}
