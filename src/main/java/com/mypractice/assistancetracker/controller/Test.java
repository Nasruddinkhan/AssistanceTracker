/**
 * nasru
 * Test.java
 * Apr 5, 2020
 */
package com.mypractice.assistancetracker.controller;

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
		Test t = new Test();
		t.print(null);
	}
}
