package leetcode;

import java.util.*;

class Solution {
	public int hIndex(int[] citations) {

		int result = 0;

		if (citations.length == 0)
			return 0;

		// 최고값 찾기
		Arrays.sort(citations);
		int idx = citations[citations.length - 1];

		for (int i = idx; i >= 0; i--) { // h-index 후보들

			int up = 0;
			int down = 0;
			for (int j = citations.length - 1; j >= 0; j--) {
				if (citations[j] >= i)
					up++;
				else {
					down = j + 1;
					break;
				}
			}

			if (up >= i) {
				result = i;
				break;
			}
		}

		return result;
	}
}
