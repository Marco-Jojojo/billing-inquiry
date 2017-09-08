package com.pei.billinginquiry.billinginquiry.service;

import com.pei.billinginquiry.billinginquiry.model.FilenetDoc;
import com.pei.billinginquiry.billinginquiry.model.FilenetDocParams;
import java.util.List;

/**
 * Service layer for Filenet Documents.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public interface FilenetDocService
{
    /**
     * Gets filenet documents by date range.
     * @param filenetDocParams Includes: First date, Second date to limit the range, and Agency code.
     * @return A list of Filenet documents.
     */
    List<FilenetDoc> getFilenetDocByDateRange(FilenetDocParams filenetDocParams);
}
