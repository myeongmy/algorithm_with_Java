//스택을 이용한 쇠막대기 문제

package 프로그래머스;

import java.util.*;

class Solution11 {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>(); // 여는 괄호의 인덱스 저장

		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				st.push(i);
			} else if (arrangement.charAt(i) == ')') {
				if (st.peek() == i - 1) { // 레이저인 경우
					st.pop();
					answer += st.size();
				} else { // 막대기의 끝인 경우
					answer++;
					st.pop();
				}
			}
		}
		return answer;
	}
}

public class IronBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arrangement = "()(((()())(())()))(())";
		System.out.println(new Solution11().solution(arrangement));
	}

}
