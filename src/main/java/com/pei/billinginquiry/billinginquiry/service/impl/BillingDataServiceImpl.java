package com.pei.billinginquiry.billinginquiry.service.impl;

import com.pei.billinginquiry.billinginquiry.dao.BillingDataDAO;
import com.pei.billinginquiry.billinginquiry.model.BillingData;
import com.pei.billinginquiry.billinginquiry.model.BillingDataParams;
import com.pei.billinginquiry.billinginquiry.service.BillingDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 8, 2017
 */
@Service
public class BillingDataServiceImpl implements BillingDataService
{
    @Autowired
    private BillingDataDAO billingDataDAO;

    @Override
    public List<BillingData> getBillingData(BillingDataParams billingDataParams) {
        return billingDataDAO.getBillingData(billingDataParams.getAgencyCode(), billingDataParams.getPolicyKey());
    }
    
}
