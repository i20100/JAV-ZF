package test;

import java.util.Arrays;

public class CompareArraysTest {
	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] tip = {1, 1, 4, 2}; // Init Variable Code


	public static void main(String[] args) {
		boolean areEqual = Arrays.equals(code, tip);
	System.out.println(areEqual);
	}
}