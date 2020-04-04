//스택을 이용한 탑 문제(블로그 포스팅)

package 프로그래머스;

//오큰수와 비슷한 문제
import java.util.*;

class Solution12 {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		Stack<Integer> st = new Stack<Integer>(); // 인덱스 저장
		for (int i = heights.length - 1; i >= 0; i--) {
			if (i == heights.length - 1)
				st.push(heights.length - 1);

			if (heights[i] > heights[st.peek()]) {
				answer[st.pop()] = i + 1;

				while (st.size() > 0 && heights[st.peek()] < heights[i]) {
					answer[st.pop()] = i + 1;
				}
				st.push(i);
			} else {
				st.push(i);
			}
		}
		return answer;
	}
}

public class Tower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 6, 9, 5, 7, 4 };
		int[] answer = new Solution12().solution(heights);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
