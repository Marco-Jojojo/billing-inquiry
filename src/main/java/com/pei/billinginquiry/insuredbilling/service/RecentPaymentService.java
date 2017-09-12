package com.pei.billinginquiry.insuredbilling.service;

import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
import java.util.List;

/**
 * Service layer for Recent Payments.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
public interface RecentPaymentService
{
    /**
     * Gets Recent Payments given a client ID.
     * @param clientId Client identifier.
     * @return A list of Recent Payments.
     */
    List<RecentPayment> getRecentPayments(int clientId);
}
