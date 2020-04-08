//시뮬레이션 문제

package 프로그래머스;

class Solution20 {
	public int[] solution(int n) {
		int[] answer = new int[(int) Math.pow(2, n) - 1];
		answer[0] = 0;
		for (int i = 2; i <= n; i++) {
			int center = (int) Math.pow(2, i - 1) - 1;
			answer[center] = 0;
			for (int j = center - 1; j >= 0; j--) {
				int dist = center - j;
				if (answer[j] == 0)
					answer[center + dist] = 1;
				else if (answer[j] == 1)
					answer[center + dist] = 0;
			}
		}
		return answer;
	}
}

public class Paperfolding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = new Solution20().solution(3);

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
