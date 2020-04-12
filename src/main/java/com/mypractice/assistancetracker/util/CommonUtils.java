/**
 * nasru
 * CommonUtils.java
 * Mar 28, 2020
 */
package com.mypractice.assistancetracker.util;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author nasru "^[A-Z]{3}"
 */
public interface CommonUtils {
	Predicate<Collection<?>> CHECK_LIST_NULL_OR_EMPLTY = l -> l == null || l.isEmpty();
	Function<Boolean, String> RESPONSE_MSG = s -> s ? ErrorConstant.RECORD_SUCCESS : ErrorConstant.UPDATE_SUCCESS;
	public static final String MSG = "msg";
	public static final String CSS = "css";
	public static final int LEN_2 = 2;
	public static final String ALPHA_2_CODE = "ALPHA_2_CODE";
	public static final String NUMERIC_CODE = "NUMERIC_CODE";
	public static final String START_DOLLAR = "*$";
	public static final String ONLY_DIGIT = "^[0-9]";
	public static final String ONLY_APHA_CHAR_PATTERN = "^[A-Z]";
	public static final String ONLY_CHAR_PATTERN = "^[A-Za-z\\s]";
	public static final String OPEN_CURLY_BRESH = "{";
	public static final String CLOSE_CURLY_BRESH = "}";
	public static final String COUNTRY_CODE_INVALID = "{country.countrycode.empty}";
	public static final String COUNTRY_NAME_INVALID = "{country.countryname.empty}";
	public static final String INVALID_FIELD_SIZE = "{fieldname.size}";
	public static final String ONLY_ALPHABET_ALLOW = "{country.fieldname.alphachar}";
	public static final String ONLY_CHAR_ALLOW = "{country.fieldname.onlychar}";
	public static final String ONLY_DIGIT_ALLOW = "{fieldname.onlydigit}";
	public static final String URL_ID = "ID";
	public static final String FIELD_INVALID = "{field.empty}";
	public static final int LEN_50 = 50;
	public static final String COUNTRY_CODE = "COUNTRY_CODE";
	public static final String COUNTRY_NAME = "COUNTRY_NAME";
	public static final String COUNTRY_MASTER = "COUNTRY_MASTER";
	public static final int LEN_3 = 3;
	public static final int LEN_6 = 6;
	public static final String STATE = "state";
	public static final String STATE_URL = "/state";
	public static final String SLASH = "/";
	public static final String RIDIRECT = "redirect";
	public static final String URL_ACTION = ".do";
	public static final String COUNTRY_URL = "/country";
	public static final String SAVE = "save";
	public static final String DELETE_URL = "delete";
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
	public static final int MST_LEN_100 = 100;
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
	public static final String UNDER_LINE = "_";
	public static final String STATES = "states";
	public static final String EDI_COUNTRY_URL = "/editCountry";
	public static final String COUNTRYCODE = "COUNTRYCODE";
	public static final String STATE_CODE = "STATE_CODE";
	public static final String STATE_NAME = "STATE_NAME";
	public static final String EDIT = "/edit";
	public static final String DELETE = "/delete";
	public static final String CITY_CODE = "CITY_CODE";
	public static final String CITY_NAME = "CITY_NAME";
	public static final String CITY_ALPHA_CODE = "CITY_ALPHA_CODE";
	public static final String CITIES = "cities";
	public static final String PIN_CODE = "PIN_CODE";
	public static final String PINCODES = "pincodes";
	public static final String STR_TRUE = "true";
	public static final String STR_FALSE = "false";
	public static final String PROFESSION_URL = "/profession";
	public static final String PROFESSION = "profession";
	public static final String REASON_URL = "/needy_problems";
	public static final String REASON = "needy_problems";
	public static final String PAYMENT_MODE_URL = "/payment_mode";
	public static final String PAYMENT_MODE = "payment_mode";
	public static final String PAYMENTS = "payments";
	public static final String RELATIONSHIP_URL = "/relationship";
	public static final String RELATIONSHIP = "relationship";
	public static final String NEEDY_REFERED = "needy_refered";
	public static final String NEEDY_REFERED_URL = "/needy_refered";
	public static final String SequenceId_Generator = "com.mypractice.assistancetracker.util.StringPrefixedSequenceIdGenerator";
	public static final String TEN_DIGIT ="%010d";
	public static final String PAYMENT_MODE_PREFIX = "PAYMODE_" ;
	public static final String RELATIONSHIP_MODE_PREFIX = "RELATIONSHIP_" ;
	public static final String RELATIONSHIPS="relationships";
	public static final String SEQ = "SEQ" ;
	public static final String LEN_1 = "1";
	public static final String VERSION="VERSION";
	public static final String EDIT_DATE="EDIT_DATE";
	public static final String ADD_DATE="ADD_DATE";
	public static final String NAME="NAME";
	public static boolean checkListNullOrEmpty(Collection<?> list) {
		return CHECK_LIST_NULL_OR_EMPLTY.test(list);
	}
	public static String responseResult(String isNew) {
		return RESPONSE_MSG.apply(Boolean.valueOf(isNew));
	}
}
