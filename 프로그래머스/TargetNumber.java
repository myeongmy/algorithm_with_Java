//비트마스크를 이용한 완전 탐색 문제

package 프로그래머스;

class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		for (int i = 0; i <= (1 << numbers.length) - 1; i++) {
			int sum = 0;
			for (int j = numbers.length - 1; j >= 0; j--) {
				if ((i & (1 << j)) != 0) { // +이면
					sum += numbers[(numbers.length - 1) - j];
				} else if ((i & (1 << j)) == 0) {
					sum -= numbers[(numbers.length - 1) - j];
				}
			}
			if (sum == target)
				answer++;
		}
		return answer;
	}
}

public class TargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(new Solution().solution(numbers, target));

	}

}
