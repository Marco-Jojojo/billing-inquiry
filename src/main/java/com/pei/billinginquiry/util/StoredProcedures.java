package com.pei.billinginquiry.util;

/**
 * Class to include stored procedures or queries.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class StoredProcedures
{
    public static final String LAST_POLICY_CREATED = "EXEC dbo.getLastPolicyCreatedTest ";
    public static final String GET_FILENET_DOC_BY_DATE = "EXEC dbo.getFilenetDocByDate @FromDate = ?, @ToDate = ?, @Agency = ? ";
    public static final String GET_BILLING_DATA = "EXEC dbo.getBillingData @SubmissionNumber = ?, @AgencyCode = ? ";
}
