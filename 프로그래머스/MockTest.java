//브루트 포스문제 (그냥 다 해보기)
package 프로그래머스;

import java.util.*;

class Solution4 {
	public int[] solution(int[] answers) {
		int[] number1 = { 1, 2, 3, 4, 5 };
		int[] number2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] number3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] correct = new int[3];
		// 1번 사람이 정답 맞춘 개수
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == number1[i % 5])
				correct[0]++;
		}
		// 2번 사람이 정답 맞춘 개수
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == number2[i % 8])
				correct[1]++;
		}

		// 3번 사람이 정답 맞춘 개수
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == number3[i % 10])
				correct[2]++;
		}
		// 최대 값 구하기
		int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 3; i++) {
			if (correct[i] == max)
				list.add(i);
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i) + 1;
		return answer;
	}
}

public class MockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = { 1, 2, 3, 4, 5 };
		int[] arr = new Solution4().solution(answers);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");

	}

}
