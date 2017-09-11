package com.pei.billinginquiry.billinginquiry.model;

import java.io.Serializable;

/**
 * @author alfonso.pech
 *
 */
public class PolicyDetailParams implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String agencyCode;
	private int policyKey;

	/**
	 * @return agencyCode
	 */
	public String getAgencyCode() {
		return agencyCode;
	}

	/**
	 * @param value
	 */
	public void setAgencyCode(final String value) {
		this.agencyCode = value;
	}

	/**
	 * @return policyKey
	 */
	public int getPolicyKey() {
		return policyKey;
	}

	/**
	 * @param value
	 */
	public void setPolicyKey(final int value) {
		this.policyKey = value;
	}

	@Override
	public String toString() {
		return "PolicyDetailParams{" + "agencyCode=" + agencyCode + ", policyKey=" + policyKey + '}';
	}
}
