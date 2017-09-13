package com.pei.billinginquiry.auditinquiry.model;

import java.io.Serializable;
import java.util.Date;

/**
 * interim audit pojo class used to transport data trough the audit flow.
 * 
 * @author carlos.acosta
 *
 */
public class AuditInquiry implements Serializable {
	private static final long serialVersionUID = 4773663293974553898L;
	private String solicitationNumber;
	private Date billingPeriodFrom;
	private Date billingPeriodTo;
	private String billedIndicatorYN;
	private String solicitationType;
	private String policyNumber;
	private Date dueDate;
	private String status;

	public String getSolicitationNumber() {
		return solicitationNumber;
	}

	public void setSolicitationNumber(final String solicitationNumber) {
		this.solicitationNumber = solicitationNumber;
	}

	public Date getBillingPeriodFrom() {
		return billingPeriodFrom;
	}

	public void setBillingPeriodFrom(final Date billingPeriodFrom) {
		this.billingPeriodFrom = billingPeriodFrom;
	}

	public Date getBillingPeriodTo() {
		return billingPeriodTo;
	}

	public void setBillingPeriodTo(final Date billingPeriodTo) {
		this.billingPeriodTo = billingPeriodTo;
	}

	public String getBilledIndicatorYN() {
		return billedIndicatorYN;
	}

	public void setBilledIndicatorYN(final String billedIndicatorYN) {
		this.billedIndicatorYN = billedIndicatorYN;
	}

	public void setPolicyNumber(final String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public String getSolicitationType() {
		return solicitationType;
	}

	public void setSolicitationType(final String solicitationType) {
		this.solicitationType = solicitationType;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(final Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}
}
