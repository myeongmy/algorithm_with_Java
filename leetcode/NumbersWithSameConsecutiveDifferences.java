package leetcode;

import java.util.*;

//브루트 포스

class Solution {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> resultList;

	static void go(int index, int N, int K) {
		if (index >= N) {
			resultList.add(Integer.parseInt(sb.toString()));
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (N != 1 && index == 0 && i == 0)
				continue;
			if (index != 0 && Math.abs(sb.charAt(sb.length() - 1) - Integer.toString(i).charAt(0)) != K)
				continue;
			sb.append(i);
			go(index + 1, N, K);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public int[] numsSameConsecDiff(int N, int K) {
		resultList = new ArrayList<Integer>();

		go(0, N, K);

		int[] result = new int[resultList.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = resultList.get(i);

		return result;
	}
}
