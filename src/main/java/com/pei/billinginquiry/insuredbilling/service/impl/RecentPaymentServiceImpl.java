package com.pei.billinginquiry.insuredbilling.service.impl;

import com.pei.billinginquiry.insuredbilling.dao.RecentPaymentDAO;
import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
import com.pei.billinginquiry.insuredbilling.service.RecentPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
@Service
public class RecentPaymentServiceImpl implements RecentPaymentService
{
    @Autowired
    private RecentPaymentDAO recentPaymentDAO;
    
    @Override
    public List<RecentPayment> getRecentPayments(int clientId) {
        return recentPaymentDAO.getRecentPayments(clientId);
    }

}
