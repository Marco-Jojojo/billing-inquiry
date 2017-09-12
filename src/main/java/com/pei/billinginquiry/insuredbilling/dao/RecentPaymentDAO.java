package com.pei.billinginquiry.insuredbilling.dao;

import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
import java.util.List;

/**
 * DAO layer for Recent Payments.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public interface RecentPaymentDAO
{
    /**
     * Execution of the existing stored procedure dbo.RecentPayments.
     * @param clientId Client identifier.
     * @return A list of Recent Payments of the client.
     */
    List<RecentPayment> getRecentPayments(int clientId);
}
