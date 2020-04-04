//������ �̿��� �踷��� ����

package ���α׷��ӽ�;

import java.util.*;

class Solution11 {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>(); // ���� ��ȣ�� �ε��� ����

		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				st.push(i);
			} else if (arrangement.charAt(i) == ')') {
				if (st.peek() == i - 1) { // �������� ���
					st.pop();
					answer += st.size();
				} else { // ������� ���� ���
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
