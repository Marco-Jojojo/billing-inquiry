package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
public class PolicySearch implements Serializable {

	private static final long serialVersionUID = 402948833155186918L;

	private int policyKey;
	private String custName;
	private String policyNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp effectiveDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	private Timestamp expirationDate;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String status;

	@JsonProperty("PolicyKey")
	public int getPolicyKey() {
		return policyKey;
	}

	public void setPolicyKey(final int policyKey) {
		this.policyKey = policyKey;
	}

	@JsonProperty("CustName")
	public String getCustName() {
		return custName;
	}

	public void setCustName(final String custName) {
		this.custName = custName;
	}

	@JsonProperty("PolicyNo")
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(final String policyNo) {
		this.policyNo = policyNo;
	}

	@JsonProperty("EffectiveDate")
	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(final Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@JsonProperty("ExpirationDate")
	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(final Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	@JsonProperty("Addr1")
	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(final String addr1) {
		this.addr1 = addr1;
	}

	@JsonProperty("Addr2")
	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(final String addr2) {
		this.addr2 = addr2;
	}

	@JsonProperty("City")
	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	@JsonProperty("State")
	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PolicySearch{" + "policyKey=" + policyKey + ", custName=" + custName + ", policyNo=" + policyNo
				+ ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", city=" + city + ", state=" + state + ", status=" + status + "}";
	}

}
