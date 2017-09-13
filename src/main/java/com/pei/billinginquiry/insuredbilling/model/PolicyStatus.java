package com.pei.billinginquiry.insuredbilling.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfonso.pech
 *
 */
public class PolicyStatus implements Serializable {

	/**
	 * Serializable for PolicyStatus
	 */
	private static final long serialVersionUID = 1L;

	private int submissionNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp effectiveDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp expirationDate;
	private int estAnnualPremium;
	private double fees;
	private String billFrequency;
	private String billType;
	private String status;
	private String reason;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp cancelDate;
	private double cancelPremiumDue;

	/**
	 * @return submissionNumber
	 */
	@JsonProperty("SUBMISSION_NUMBER")
	public int getSubmissionNumber() {
		return submissionNumber;
	}

	/**
	 * @param submissionNumber
	 */
	public void setSubmissionNumber(final int submissionNumber) {
		this.submissionNumber = submissionNumber;
	}

	/**
	 * @return effectiveDate
	 */
	@JsonProperty("EffectiveDate")
	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate
	 */
	public void setEffectiveDate(final Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return expirationDate
	 */
	@JsonProperty("ExpirationDate")
	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate
	 */
	public void setExpirationDate(final Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return estAnnualPremium
	 */
	@JsonProperty("EstAnnualPremium")
	public int getEstAnnualPremium() {
		return estAnnualPremium;
	}

	/**
	 * @param estAnnualPremium
	 */
	public void setEstAnnualPremium(final int estAnnualPremium) {
		this.estAnnualPremium = estAnnualPremium;
	}

	/**
	 * @return fees
	 */
	@JsonProperty("Fees")
	public double getFees() {
		return fees;
	}

	/**
	 * @param fees
	 */
	public void setFees(final double fees) {
		this.fees = fees;
	}

	/**
	 * @return billFrequency
	 */
	@JsonProperty("BillFrequency")
	public String getBillFrequency() {
		return billFrequency;
	}

	/**
	 * @param billFrequency
	 */
	public void setBillFrequency(final String billFrequency) {
		this.billFrequency = billFrequency;
	}

	/**
	 * @return billType
	 */
	@JsonProperty("BillType")
	public String getBillType() {
		return billType;
	}

	/**
	 * @param billType
	 */
	public void setBillType(final String billType) {
		this.billType = billType;
	}

	/**
	 * @return status
	 */
	@JsonProperty("Status")
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * @return reason
	 */
	@JsonProperty("Reason")
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 */
	public void setReason(final String reason) {
		this.reason = reason;
	}

	/**
	 * @return cancelDate
	 */
	@JsonProperty("CancelDate")
	public Timestamp getCancelDate() {
		return cancelDate;
	}

	/**
	 * @param value
	 */
	public void setCancelDate(final Timestamp value) {
		this.cancelDate = value;
	}

	/**
	 * @return cancelPremiumDue
	 */
	@JsonProperty("CancelPremiumDue")
	public double getCancelPremiumDue() {
		return cancelPremiumDue;
	}

	/**
	 * @param cancelPremiumDue
	 */
	public void setCancelPremiumDue(final double cancelPremiumDue) {
		this.cancelPremiumDue = cancelPremiumDue;
	}

	@Override
	public String toString() {
		return "PolicyStatus {" + "submissionNumber=" + submissionNumber + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + ", estAnnualPremium=" + estAnnualPremium + ", fees=" + fees
				+ ", billFrequency=" + billFrequency + ", billType=" + billType + ", status=" + status + ", reason="
				+ reason + ", cancelDate=" + cancelDate + ", cancelPremiumDue=" + cancelPremiumDue + "}";
	}

}
