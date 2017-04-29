package main.java;

import java.util.*;

class CountRepeatedLetterOrDigitInString {
	public static void main(String[] args) throws java.lang.Exception {
		String str = "asdfasdfafk asd234asda";
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] arr = str.toCharArray();

		for (char value : arr) {
			if (Character.isLetterOrDigit(value)) {
				if (charMap.containsKey(value)) {
					charMap.put(value, charMap.get(value) + 1);
				} else {
					charMap.put(value, 1);
				}
			}
		}
		System.out.println(charMap);
	}
}
