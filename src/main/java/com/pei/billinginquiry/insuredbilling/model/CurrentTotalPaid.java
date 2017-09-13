package com.pei.billinginquiry.insuredbilling.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfonso.pech
 *
 */
public class CurrentTotalPaid implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int submissionNumber;
	private double totalPaid;

	/**
	 * @return submissionNumber
	 */
	@JsonProperty("SUBMISSION_NUMBER")
	public int getSubmissionNumber() {
		return submissionNumber;
	}

	/**
	 * @param value
	 */
	public void setSubmissionNumber(final int value) {
		this.submissionNumber = value;
	}

	/**
	 * @return totalPaid
	 */
	@JsonProperty("TotalPaid")
	public double getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @param value
	 */
	public void setTotalPaid(final double value) {
		this.totalPaid = value;
	}

	@Override
	public String toString() {
		return "CurrentTotalPaid{" + "submissionNumber=" + submissionNumber + ", totalPaid=" + totalPaid + "}";
	}
}
