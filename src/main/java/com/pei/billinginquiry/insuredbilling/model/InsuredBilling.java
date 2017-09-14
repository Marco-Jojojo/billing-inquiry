package com.pei.billinginquiry.insuredbilling.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public class InsuredBilling implements Serializable{

	private static final long serialVersionUID = -5658022213556440146L;
	
	private String policyNumber;
	private String billingKey;
	private String transactionDesc;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
	private Timestamp fromDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
	private Timestamp toDate;
	private double amount;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM/dd/yyyy HH:mm:ss")
	private Timestamp dueDate;
	
	@JsonProperty("PolicyNumber")
	public String getPolicyNumber() {
		return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	@JsonProperty("BillingKey")
	public String getBillingKey() {
		return billingKey;
	}
	
	public void setBillingKey(String billingKey) {
		this.billingKey = billingKey;
	}
	
	@JsonProperty("TransactionNumber")
	public String getTransactionDesc() {
		return transactionDesc;
	}
	
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	
	@JsonProperty("FromDate")
	public Timestamp getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	
	@JsonProperty("ToDate")
	public Timestamp getToDate() {
		return toDate;
	}
	
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	
	@JsonProperty("Amount")
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@JsonProperty("DueDate")
	public Timestamp getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "InsuredBilling {" + "policyNumber=" + policyNumber + ", billingKey=" + billingKey + ", transactionDesc="
				+ transactionDesc + ", fromDate=" + fromDate + ", toDate=" + toDate + ", amount=" + amount
				+ ", dueDate=" + dueDate + "}";
	}
	
	
	
	
	
	
	

}
