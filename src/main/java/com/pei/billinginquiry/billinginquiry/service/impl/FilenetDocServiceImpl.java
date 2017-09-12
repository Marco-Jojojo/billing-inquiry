package com.pei.billinginquiry.billinginquiry.service.impl;

import com.pei.billinginquiry.billinginquiry.dao.FilenetDocDAO;
import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.billinginquiry.model.FilenetDocParams;
import com.pei.billinginquiry.billinginquiry.service.FilenetDocServiceTest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@Service
public class FilenetDocServiceImpl implements FilenetDocServiceTest
{
    @Autowired
    private FilenetDocDAO filenetDocDAO;

    @Override
    public List<FilenetDoc> getFilenetDocByDateRange(FilenetDocParams filenetDocParams) {
        return filenetDocDAO.getFilenetDocByDateRange(filenetDocParams.getFromDate(), filenetDocParams.getToDate(), filenetDocParams.getAgencyCode());
    }
    
}
