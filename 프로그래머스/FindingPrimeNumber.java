//브루트 포스 문제 (순열)
package 프로그래머스;

import java.util.*;

class Solution5 {
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> hs = new HashSet<Integer>();

	static void go(int index, String numbers, int M, int[] c) {
		if (index == M) {
			int a = Integer.parseInt(sb.toString());
			if (a == 0 || a == 1)
				return;
			for (int i = 2; i * i <= a; i++) {
				if (a % i == 0)
					return;
			}
			hs.add(a);
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			sb.append(numbers.charAt(i));
			go(index + 1, numbers, M, c);
			c[i] = 0;
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public int solution(String numbers) {
		int answer = 0;
		for (int i = 1; i <= numbers.length(); i++) {
			int[] c = new int[numbers.length()];
			go(0, numbers, i, c);
		}

		answer = hs.size();
		return answer;
	}
}

public class FindingPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5().solution("17"));
	}

}
