package com.pei.billinginquiry.insuredbilling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public class InsuredAudit implements Serializable
{
    private static final long serialVersionUID = 3656663293974553901L;
    
    private String policyNumber;
    private String solicitationNumber;
    private String auditType;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp billingPeriodFrom;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp billingPeriodTo;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp dueDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
    private Timestamp dateReceived;
    private String auditComment;

    @JsonProperty("PolicyNumber")
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @JsonProperty("SolicitationNumber")
    public String getSolicitationNumber() {
        return solicitationNumber;
    }

    public void setSolicitationNumber(String solicitationNumber) {
        this.solicitationNumber = solicitationNumber;
    }

    @JsonProperty("AuditType")
    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    @JsonProperty("Billing_Period_From")
    public Timestamp getBillingPeriodFrom() {
        return billingPeriodFrom;
    }

    public void setBillingPeriodFrom(Timestamp billingPeriodFrom) {
        this.billingPeriodFrom = billingPeriodFrom;
    }

    @JsonProperty("Billing_Period_To")
    public Timestamp getBillingPeriodTo() {
        return billingPeriodTo;
    }

    public void setBillingPeriodTo(Timestamp billingPeriodTo) {
        this.billingPeriodTo = billingPeriodTo;
    }

    @JsonProperty("DueDate")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("DATE_RECEIVED")
    public Timestamp getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Timestamp dateReceived) {
        this.dateReceived = dateReceived;
    }

    @JsonProperty("AuditComment")
    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    @Override
    public String toString() {
        return "InsuredAudit{" + "policyNumber=" + policyNumber + ", solicitationNumber=" + solicitationNumber + ", auditType=" + auditType + ", billingPeriodFrom=" + billingPeriodFrom + ", billingPeriodTo=" + billingPeriodTo + ", dueDate=" + dueDate + ", dateReceived=" + dateReceived + ", auditComment=" + auditComment + '}';
    }
    
}
