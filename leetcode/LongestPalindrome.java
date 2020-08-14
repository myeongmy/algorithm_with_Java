package leetcode;

import java.util.*;

//해시 이용하기
class Solution {
	public int longestPalindrome(String s) {

		int result = 0;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
		}

		List<Character> keyList = new ArrayList<>(hm.keySet());
		int one = 0;
		for (char a : keyList) {
			if (hm.get(a) % 2 == 0) {
				result += hm.get(a);
			} else if (hm.get(a) % 2 != 0) {
				one = 1;
				if (hm.get(a) == 1)
					continue;
				result += hm.get(a) - 1;
			}
		}

		if (one == 1)
			result++;

		return result;
	}
}
