package 프로그래머스;

//문자열 처리 - 구현

import java.util.*;

class Solution26 {
	static boolean correctString(String s) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else if (s.charAt(i) == ')') {
				if (st.empty())
					return false;
				st.pop();
			}
		}
		return true;
	}

	static String go(String str) {
		if (str.equals(""))
			return str;

		// 문자열 u, v로 분리
		int start = 0; // "(" 개수
		int end = 0; // ")" 개수

		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				start++;
			} else if (str.charAt(i) == ')') {
				end++;
			}
			if (start == end)
				break;
		}
		String u = str.substring(0, i + 1);
		String v = str.substring(i + 1);

		if (correctString(u) == true) {
			return u + go(v);
		} else {
			StringBuilder sb = new StringBuilder(u.substring(1, u.length() - 1));
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) == '(') {
					sb.setCharAt(j, ')');
				} else if (sb.charAt(j) == ')') {
					sb.setCharAt(j, '(');
				}
			}

			return "(" + go(v) + ")" + sb.toString();
		}
	}

	public String solution(String p) {
		String answer = "";
		answer = go(p);
		return answer;
	}
}

public class BracketChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p = "()))((()";
		System.out.println(new Solution26().solution(p));
	}

}
