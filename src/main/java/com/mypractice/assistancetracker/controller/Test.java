/**
 * nasru
 * Test.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

import static com.mypractice.assistancetracker.util.CommonUtils.CLOSE_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.OPEN_CURLY_BRESH;
import static com.mypractice.assistancetracker.util.CommonUtils.PAGINATION;
import static com.mypractice.assistancetracker.util.CommonUtils.SHOW_MEMBER_PAGE;
import static com.mypractice.assistancetracker.util.CommonUtils.SLASH;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ACTION;
import static com.mypractice.assistancetracker.util.CommonUtils.URL_ID;

/**
 * @author nasru
 *
 */
public class Test {
	void print(Object obj) {
		System.out.println("obj ");
	}

	void print(String obj) {
		System.out.println("string obj ");
	}

	public static void main(String[] args) {
		System.out.println(SHOW_MEMBER_PAGE+SLASH+OPEN_CURLY_BRESH+URL_ID+CLOSE_CURLY_BRESH+SLASH+PAGINATION+URL_ACTION);
		
	}
}
