package com.pei.billinginquiry.billinginquiry.dao;

import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import java.util.List;

/**
 * DAO layer for Filenet Documents.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public interface FilenetDocDAO
{
    /**
     * Execution of the stored procedure dbo.getFilenetDocByDate.
     * @param fromDate  First date.
     * @param toDate Second date to limit the range.
     * @param agencyCode Agency code.
     * @return A list of Filenet documents.
     */
    List<FilenetDoc> getFilenetDocByDateRange(String fromDate, String toDate, String agencyCode);
}
