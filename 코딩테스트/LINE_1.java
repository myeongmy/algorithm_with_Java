package 코딩테스트;

import java.util.*;

class Solution4 {
	public int solution(String inputString) {
		int answer = 0;

		Stack<Integer> st = new Stack<Integer>(); // 인덱스 저장
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) == '(' || inputString.charAt(i) == '{' || inputString.charAt(i) == '['
					|| inputString.charAt(i) == '<') {
				st.push(i);
			} else if (inputString.charAt(i) == ')' || inputString.charAt(i) == '}' || inputString.charAt(i) == ']'
					|| inputString.charAt(i) == '>') {
				if (st.size() == 0) {
					answer = -1;
					break;
				}
				st.pop();
				answer++;
			}
		}
		if (!st.empty())
			answer = -1;
		return answer;
	}
}

public class LINE_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "if (Count of eggs is 4.) {Buy milk.}";

		System.out.println(new Solution4().solution(inputString));
	}

}
