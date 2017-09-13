package com.pei.billinginquiry.billinginquiry.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pei.billinginquiry.billinginquiry.dao.PolicySearchDAO;
import com.pei.billinginquiry.billinginquiry.model.PolicySearch;
import com.pei.billinginquiry.billinginquiry.model.PolicySearchParams;
import com.pei.billinginquiry.billinginquiry.service.PolicySearchService;

/**
 * @author Manuel Solano <jose.solano@softtek.com>
 * @date Sep 11, 2017
 */
@Service
public class PolicySearchServiceImpl implements PolicySearchService {

	@Autowired
	private PolicySearchDAO policySearchDAO;

	private String queryCreate(final PolicySearchParams policySearchParams) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT p.SUBMISSION_NUMBER AS PolicyKey, RTRIM(Case When dba.DBA_NAME IS NULL OR RTRIM(dba.DBA_NAME) = '' Then ent.ENTITY_NAME Else dba.DBA_NAME End) AS CustName, RTRIM(CONCAT(CONCAT(CONCAT(CONCAT(CONCAT(p.POLICY_PREFIX_1, p.POLICY_PREFIX_2), ' '), CONVERT(varchar(10), p.POLICY_NUMBER)), '-'), p.POLICY_SUFFIX)) AS PolicyNo, p.EFFECTIVE_DATE AS EffectiveDate, p.EXPIRATION_DATE AS ExpirationDate, RTRIM(Case When loc.SUBMISSION_NUMBER IS NULL Then loc2.ADDR_1 Else loc.ADDR_1 End) AS Addr1, RTRIM(Case When loc.SUBMISSION_NUMBER IS NULL Then loc2.ADDR_2 Else loc.ADDR_2 End) AS Addr2, RTRIM(Case When loc.SUBMISSION_NUMBER IS NULL Then loc2.CITY Else loc.CITY End) AS City, Case When loc.SUBMISSION_NUMBER IS NULL Then loc2.STATE Else loc.STATE End AS State, RTRIM(stat.STATUS_DESCRIPTION) AS Status ");
		query.append("FROM (((((POLICY_MASTER p LEFT JOIN SPR_ENTITY_FILE ent ON p.SUBMISSION_NUMBER = ent.SUBMISSION_NUMBER AND ent.ENTITY_NUMBER = 1) LEFT JOIN SPR_DBA dba ON p.SUBMISSION_NUMBER = dba.SUBMISSION_NUMBER AND ent.ENTITY_NUMBER = dba.ENTITY_NUMBER AND dba.DBA_NUMBER = 1) LEFT JOIN SPR_MAILING_ADDR loc ON p.SUBMISSION_NUMBER = loc.SUBMISSION_NUMBER) LEFT JOIN SPR_LOCATION loc2 ON p.SUBMISSION_NUMBER = loc2.SUBMISSION_NUMBER AND ent.ENTITY_NUMBER = loc2.ENTITY_NUMBER AND loc2.PRIMARY_ADDRESS_IND = 'Y') LEFT JOIN MASTER_STATUS_TABLE stat ON p.STATUS_CODE = stat.STATUS_CODE AND stat.SPR_INDICATOR = 'P') LEFT JOIN SPR_SERVICE_BROKER_F sbrk ON p.SUBMISSION_NUMBER = sbrk.SUBMISSION and sbrk.AGENCY_CODE = '10600' ");
		
		String whereOrAnd = "WHERE ";
		if (!("999999".equals(policySearchParams.getAgencyCode()))) {
			query.append(whereOrAnd);
			query.append("Left((Case When sbrk.AGENCY_CODE is null Then '' Else sbrk.AGENCY_CODE End) + p.AGENCY_CODE, 5) IN ("+ policySearchParams.getAgencyCode() +") ");
			whereOrAnd = "AND ";
		}
		
		Pattern pattern = Pattern.compile("[a-zA-Z ]*([0-9]+)");
		Matcher matcher = pattern.matcher(policySearchParams.getPartialPolicy());
		if (matcher.find())
		{
			query.append(whereOrAnd);
			query.append("p.POLICY_NUMBER LIKE '" + matcher.group(1).substring(0, 6) + "%' ");
			whereOrAnd = "AND ";
		}
		
		if (policySearchParams.getPartialInsuredName().length() != 0) {
			String partialInsuredName = "'%"+ policySearchParams.getPartialInsuredName().replace("'", "''") +"%'";
			query.append(whereOrAnd);
			query.append("(((dba.DBA_NAME IS NULL OR RTRIM(dba.DBA_NAME) = '') AND UPPER(ent.ENTITY_NAME) LIKE " + partialInsuredName + ") OR UPPER(dba.DBA_NAME) LIKE " + partialInsuredName + ") ");
			whereOrAnd = "AND ";
		}
		
		query.append(whereOrAnd);
		query.append("NOT EXISTS (SELECT * FROM SPR_LOCATION loc3 WHERE loc3.SUBMISSION_NUMBER = loc2.SUBMISSION_NUMBER AND loc3.ENTITY_NUMBER = loc2.ENTITY_NUMBER AND loc3.LOCATION < loc2.LOCATION AND loc3.PRIMARY_ADDRESS_IND = 'Y') ORDER BY p.EFFECTIVE_DATE desc");
		System.out.println(query);
		return query.toString();
	}

	@Override
	public List<PolicySearch> getPolicySearch(final PolicySearchParams policySearchParams) {
		final String query = queryCreate(policySearchParams);
		return policySearchDAO.getPolicySearch(query);
	}

}
