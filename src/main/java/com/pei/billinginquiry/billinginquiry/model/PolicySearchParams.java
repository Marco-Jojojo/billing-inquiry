package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;

public class PolicySearchParams implements Serializable {

	private static final long serialVersionUID = -5919022019587403835L;

	private String agencyCode;
	private String partialPolicy;
	private String partialInsuredName;

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(final String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getPartialPolicy() {
		return partialPolicy;
	}

	public void setPartialPolicy(final String partialPolicy) {
		this.partialPolicy = partialPolicy;
	}

	public String getPartialInsuredName() {
		return partialInsuredName;
	}

	public void setPartialInsuredName(final String partialInsuredName) {
		this.partialInsuredName = partialInsuredName;
	}

	@Override
	public String toString() {
		return "PolicySearchParams{" + "agencyCode=" + agencyCode + ", partialPolicy=" + partialPolicy
				+ ", partialInsuredName=" + partialInsuredName + "}";
	}

}
