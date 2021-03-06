package com.pei.billinginquiry.util;

/**
 * Class to include stored procedures or queries.
 *
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class StoredProcedures {
	/**
	 * Stored Procedure to get the last policy created (for hello world
	 * example).
	 */
	public static final String LAST_POLICY_CREATED = "EXEC dbo.getLastPolicyCreatedTest ";

	/**
	 * Stored Procedure to get the Filenet Documents information.
	 */
	public static final String GET_FILENET_DOC_BY_DATE = "EXEC dbo.getFilenetDocByDate @FromDate = ?, @ToDate = ?, @Agency = ? ";

	/**
	 * Stored PRocedure to get the Billing Data information.
	 */
	public static final String GET_BILLING_DATA = "EXEC dbo.getBillingData @AgencyCode = ?, @SubmissionNumber = ? ";

	/**
	 * Stored procedure to get Policy Information
	 */
	public static final String GET_POLICY_DETAIL = "EXEC dbo.getPolicyDetail @AgencyCode = ?, @PolicyKey = ? ";

	/**
	 * Stored procedure to get the Recent Payments of a client.
	 */
	public static final String GET_RECENT_PAYMENTS = "EXEC dbo.RecentPayments @ClientID = ? ";

	/**
	 * Stored procedure for audit query
	 */
	public static final String GET_INTERIM_AUDITS = "EXEC dbo.AuditQuery @SubmissionNumber = ? ";

	/**
	 * Stored procedure for audit query 2
	 */
	public static final String GET_INTERIM_AUDITS_2 = "EXEC dbo.AuditQuery2 @SubmissionNumber = ? , "
			+ " SubmissionNumber2 = ? ";

	/**
	 * Stored procedure to get the Insured Audit of a client.
	 */
	public static final String GET_INSURED_AUDIT = "EXEC dbo.InsuredAuditQuery @ClientNumber = ? ";


	/**
	 * Stored procedure for CurrentTotalPaid
	 */
	public static final String GET_CURRENT_TOTAL_PAID = "EXEC dbo.CurrentTotalPaid @SubmissionNumber = ? ";

	/**
	 * Stored procedure for PolicyStatus
	 */
	public static final String GET_POLICY_STATUS = "EXEC dbo.PolicyStatus @SubmissionNumber = ? ";
	
	/**
	 * Stored procedure to get the Insured Billing of a client.
	 */
	public static final String GET_INSURED_BILLING = "EXEC dbo.InsuredBilling @ClientNumber = ? ";

}
