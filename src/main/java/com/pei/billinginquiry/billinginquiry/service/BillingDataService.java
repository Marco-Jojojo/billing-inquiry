package com.pei.billinginquiry.billinginquiry.service;

import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.billinginquiry.model.BillingDataParams;
import java.util.List;

/**
 * Service layer for Billing Data.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
public interface BillingDataService
{
    /**
     * Gets Billing Data info.
     * @param billingDataParams Includes: Agency code and Policy Key (submission number).
     * @return A list of Billing Data objects.
     */
    List<BillingData> getBillingData(BillingDataParams billingDataParams);
}
