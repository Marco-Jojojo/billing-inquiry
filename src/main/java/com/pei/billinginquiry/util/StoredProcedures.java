package com.pei.billinginquiry.util;

/**
 * Class to include stored procedures or queries.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class StoredProcedures
{
    /**
     * Stored Procedure to get the last policy created (for hello world example).
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
}
