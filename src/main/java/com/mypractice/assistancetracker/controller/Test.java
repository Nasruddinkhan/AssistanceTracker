/**
 * nasru
 * Test.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

import java.util.Objects;

import com.mypractice.assistancetracker.dto.PaymentDTO;

/**
 * @author nasru
 *
 */
public class Test {
public static void main(String[] args) {
	PaymentDTO p = new PaymentDTO();
	p.setPaymentModeName("sasfasf");
System.out.println(Objects.isNull(p));
}
}
