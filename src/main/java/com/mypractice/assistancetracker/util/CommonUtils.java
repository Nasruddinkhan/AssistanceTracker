/**
 * nasru
 * CommonUtils.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.util;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * @author nasru
 *
 */
public interface CommonUtils {
	Predicate<Collection<?>> CHECK_LIST_NULL_OR_EMPLTY = l -> l == null || l.isEmpty();
	public static final int LEN_50 = 50;
	public static final String COUNTRY_CODE = "COUNTRY_CODE";
	public static final String COUNTRY_NAME = "COUNTRY_NAME";
	public static final String COUNTRY_MASTER="COUNTRY_MASTER";
	public static final int LEN_3= 3;
	public static final String STATE = "state";
	public static final String STATE_URL = "/state";
	public static final String SLASH = "/";
	public static final String RIDIRECT = "redirect";
	public static final String URL_ACTION = ".do";
	public static final String COUNTRY_URL = "/country";
	public static final String COUNTRY = "country";
	public static final String COUNTRIES = "countries";
	public static final String CITY_URL = "/city";
	public static final String CITY = "city";
	public static final String PINCODE_URL = "/pincode";
	public static final String PINCODE = "pincode";
	public static final String COLON = ":";
	public static final String DROPDOWN_BEAN = "dropdownbean";
	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String MST_CODE_ID = "CODE_ID";
	public static final int MST_LEN_20 = 20;
	public static final int MST_LEN_50 = 50;
	public static final String MST_CODE_NAME = "CODE_NAME";
	public static final String MST_CODE_TYPE = "CODE_TYPE";
	public static final int MST_LEN_15 = 15;
	public static final String MST_CODE_APPLICATION = "CODE_APPLICATION";
	public static final String MEMBER = "/member";
	public static final String MEMBER_PAGE = "member";
	public static final String SHOW_MEMBER_PAGE = "/showmemberpage";
	public static final String MST = "/mst";
	public static final String ALL_MASTER = "/allmaster";
	public static final String MASTER = "master";
	public static boolean checkListNullOrEmpty(Collection<?> list) {
		return CHECK_LIST_NULL_OR_EMPLTY.test(list);
	}
}
