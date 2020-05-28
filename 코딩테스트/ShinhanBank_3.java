//3번 - 두 배열의 원소를 조합해 나올 수 있는 모든 경우의 수에 대해 올바른 괄호열의 총 갯수 구하기 (시간초과 예상)

package 코딩테스트;

import java.util.*;

class Solution15 {
	static boolean isCorrect(StringBuilder sb) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '(')
				st.push(i);
			else {
				if (st.empty())
					return false;
				st.pop();
			}
		}
		if (!st.empty())
			return false;
		return true;
	}

	public long solution(String[] arr1, String[] arr2) {
		long answer = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				StringBuilder sb = new StringBuilder(arr1[i]);
				sb.append(arr2[j]);
				if (isCorrect(sb)) {
					answer++;
				}
			}
		}
		return answer;
	}
}

public class ShinhanBank_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr1 = { ")()", "()", "((" };
		String[] arr2 = { "()(", "()()" };
		System.out.println(new Solution15().solution(arr1, arr2));
	}

}
