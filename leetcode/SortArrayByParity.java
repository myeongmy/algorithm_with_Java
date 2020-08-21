package leetcode;

import java.util.*;

class Solution {
	public int[] sortArrayByParity(int[] A) {
		int[] result = new int[A.length];
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0)
				even.add(A[i]);
			else
				odd.add(A[i]);
		}
		List<Integer> answer = new ArrayList<>();
		answer.addAll(even);
		answer.addAll(odd);

		for (int i = 0; i < A.length; i++)
			result[i] = answer.get(i);
		return result;
	}
}
