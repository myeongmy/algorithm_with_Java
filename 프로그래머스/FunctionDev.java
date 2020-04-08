//스택/큐 문제

package 프로그래머스;

import java.util.*;

class Solution19 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] day = new int[progresses.length];

		for (int i = 0; i < day.length; i++) {
			day[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0)
				day[i]++;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		int num = 0;

		for (int i = 0; i < day.length; i++) {
			if (st.size() == 0) {
				st.push(day[i]);
				continue;
			}
			if (st.peek() >= day[i])
				num++;
			else {
				list.add(num + 1);
				num = 0;
				st.pop();
				st.push(day[i]);
			}
		}
		if (!st.empty())
			list.add(num + 1);

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		return answer;
	}
}

public class FunctionDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] answer = new Solution19().solution(progresses, speeds);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
