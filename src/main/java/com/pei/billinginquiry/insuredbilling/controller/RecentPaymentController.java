package com.pei.billinginquiry.insuredbilling.controller;

import com.pei.billinginquiry.insuredbilling.model.RecentPayment;
import com.pei.billinginquiry.insuredbilling.service.RecentPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 12, 2017
 */
@RestController
@RequestMapping("/InsuredBilling")
public class RecentPaymentController
{
    @Autowired
    private RecentPaymentService recentPaymentService;
    
    @RequestMapping(value = {"/RecentPayments/{clientId}"}, method = RequestMethod.GET)
    public List<RecentPayment> getRecentPayments(@PathVariable int clientId) {
        return recentPaymentService.getRecentPayments(clientId);
    }
}
