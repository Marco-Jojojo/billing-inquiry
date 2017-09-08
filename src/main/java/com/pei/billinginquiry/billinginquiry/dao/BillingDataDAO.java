package com.pei.billinginquiry.billinginquiry.dao;

import com.pei.billinginquiry.billinginquiry.model.BillingData;
import java.util.List;

/**
 * DAO layer for Billing Data.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
public interface BillingDataDAO
{
    /**
     * Execution of the stored procedure dbo.getBillingData.
     * @param agencyCode Agency code.
     * @param policyKey Policy Key (submission number).
     * @return A list of Billing Data objects
     */
    List<BillingData> getBillingData(String agencyCode, int policyKey);
}
