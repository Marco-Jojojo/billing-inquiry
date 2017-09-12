package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfonso.pech
 *
 */
public class PolicyDetail implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int PolicyKey;
	private String CustName;
	private String Addr1;
	private String Addr2;
	private String City;
	private String State;
	private int Zip;
	private String PolicyNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp EffectiveDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp ExpirationDate;
	private int EstAnnPremium;
	private Double Fees;
	private String PaymentPlanType;
	private String PaymentPlanFrequency;
	private String Status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp StatusDate;
	private String UseStatusDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp CancelDate;
	private String UseCancelStatus;
	private String UseReason;
	private String CalcPending;
	private String PendingApplies;
	private String PendingAmount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp PendingDate;

	@JsonProperty("PolicyKey")
	public int getPolicyKey() {
		return PolicyKey;
	}

	public void setPolicyKey(final int policyKey) {
		PolicyKey = policyKey;
	}

	@JsonProperty("CustName")
	public String getCustName() {
		return CustName;
	}

	public void setCustName(final String custName) {
		CustName = custName;
	}

	@JsonProperty("Addr1")
	public String getAddr1() {
		return Addr1;
	}

	public void setAddr1(final String addr1) {
		Addr1 = addr1;
	}

	@JsonProperty("Addr2")
	public String getAddr2() {
		return Addr2;
	}

	public void setAddr2(final String addr2) {
		Addr2 = addr2;
	}

	@JsonProperty("City")
	public String getCity() {
		return City;
	}

	public void setCity(final String city) {
		City = city;
	}

	@JsonProperty("State")
	public String getState() {
		return State;
	}

	public void setState(final String state) {
		State = state;
	}

	@JsonProperty("Zip")
	public int getZip() {
		return Zip;
	}

	public void setZip(final int zip) {
		Zip = zip;
	}

	@JsonProperty("PolicyNo")
	public String getPolicyNo() {
		return PolicyNo;
	}

	public void setPolicyNo(final String policyNo) {
		PolicyNo = policyNo;
	}

	@JsonProperty("EffectiveDate")
	public Timestamp getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(final Timestamp effectiveDate) {
		EffectiveDate = effectiveDate;
	}

	@JsonProperty("ExpirationDate")
	public Timestamp getExpirationDate() {
		return ExpirationDate;
	}

	public void setExpirationDate(final Timestamp expirationDate) {
		ExpirationDate = expirationDate;
	}

	@JsonProperty("EstAnnPremium")
	public int getEstAnnPremium() {
		return EstAnnPremium;
	}

	public void setEstAnnPremium(final int estAnnPremium) {
		EstAnnPremium = estAnnPremium;
	}

	@JsonProperty("Fees")
	public Double getFees() {
		return Fees;
	}

	public void setFees(final Double fees) {
		Fees = fees;
	}

	@JsonProperty("PaymentPlanType")
	public String getPaymentPlanType() {
		return PaymentPlanType;
	}

	public void setPaymentPlanType(final String paymentPlanType) {
		PaymentPlanType = paymentPlanType;
	}

	@JsonProperty("PaymentPlanFrequency")
	public String getPaymentPlanFrequency() {
		return PaymentPlanFrequency;
	}

	public void setPaymentPlanFrequency(final String paymentPlanFrequency) {
		PaymentPlanFrequency = paymentPlanFrequency;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(final String status) {
		Status = status;
	}

	@JsonProperty("StatusDate")
	public Timestamp getStatusDate() {
		return StatusDate;
	}

	public void setStatusDate(final Timestamp statusDate) {
		StatusDate = statusDate;
	}

	@JsonProperty("UseStatusDate")
	public String getUseStatusDate() {
		return UseStatusDate;
	}

	public void setUseStatusDate(final String useStatusDate) {
		UseStatusDate = useStatusDate;
	}

	@JsonProperty("CancelDate")
	public Timestamp getCancelDate() {
		return CancelDate;
	}

	public void setCancelDate(final Timestamp cancelDate) {
		CancelDate = cancelDate;
	}

	@JsonProperty("UseCancelStatus")
	public String getUseCancelStatus() {
		return UseCancelStatus;
	}

	public void setUseCancelStatus(final String useCancelStatus) {
		UseCancelStatus = useCancelStatus;
	}

	@JsonProperty("UseReason")
	public String getUseReason() {
		return UseReason;
	}

	public void setUseReason(final String useReason) {
		UseReason = useReason;
	}

	@JsonProperty("CalcPending")
	public String getCalcPending() {
		return CalcPending;
	}

	public void setCalcPending(final String calcPending) {
		CalcPending = calcPending;
	}

	@JsonProperty("PendingApplies")
	public String getPendingApplies() {
		return PendingApplies;
	}

	public void setPendingApplies(final String pendingApplies) {
		PendingApplies = pendingApplies;
	}

	@JsonProperty("PendingAmount")
	public String getPendingAmount() {
		return PendingAmount;
	}

	public void setPendingAmount(final String pendingAmount) {
		PendingAmount = pendingAmount;
	}

	@JsonProperty("PendingDate")
	public Timestamp getPendingDate() {
		return PendingDate;
	}

	public void setPendingDate(final Timestamp pendingDate) {
		PendingDate = pendingDate;
	}

}
