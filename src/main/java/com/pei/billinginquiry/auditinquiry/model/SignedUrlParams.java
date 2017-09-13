package com.pei.billinginquiry.auditinquiry.model;

/**
 * this is a set of parameter used to get a signed url encoded and encrypted.
 * 
 * @author carlos.acosta
 *
 */
public class SignedUrlParams {
	private String _interface;
	private String item;
	private String policy;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String title;
	private String phone;
	private String fax;
	private String email;
	private String solicitation;
	private String multiAudits;

	public String getItem() {
		return item;
	}

	public void setItem(final String item) {
		this.item = item;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(final String policy) {
		this.policy = policy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(final String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(final String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSolicitation() {
		return solicitation;
	}

	public void setSolicitation(final String solicitation) {
		this.solicitation = solicitation;
	}

	public String getMultiAudits() {
		return multiAudits;
	}

	public void setMultiAudits(final String multiAudits) {
		this.multiAudits = multiAudits;
	}

	public void setInterface(final String _interface) {
		this._interface = _interface;
	}

	public String getInterface() {
		return this._interface;
	}
}
