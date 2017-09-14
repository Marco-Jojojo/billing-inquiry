package com.pei.billinginquiry.auditinquiry.model;

import java.io.Serializable;

/**
 * Parameter class for trupay methods in auditinquiry.
 * 
 * @author carlos.acosta
 *
 */
public class UserDetailParameters implements Serializable {
	/**
	 * generated serial id.
	 */
	private static final long serialVersionUID = -1123385621396348546L;
	private String userId;
	private String email;
	private String policyToken;

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPolicyToken() {
		return policyToken;
	}

	public void setPolicyToken(final String policyToken) {
		this.policyToken = policyToken;
	}
}
