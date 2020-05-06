//백준 1644번
//투 포인터 알고리즘 문제 풀이
//주어진 수 N이하의 소수를 모두 구한 후, 투 포인터 알고리즘 이용

package 백준;

import java.util.*;

public class N_1644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		// 에라토스테네스의 체 이용해서 N 이하의 소수 찾기
		boolean[] A = new boolean[N + 1]; // false면 소수, true면 합성수
		ArrayList<Integer> prime = new ArrayList<Integer>();

		for (int i = 2; i <= N; i++) {
			if (A[i] == false) {
				for (int j = i + i; j <= N; j += i) {
					A[j] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (A[i] == false)
				prime.add(i);
		}

		int start = 0;
		int end = 0;
		int result = 0;
		int sum = 0;

		while (start < prime.size()) {
			if (sum == N) {
				result++;
				start++;
				sum -= prime.get(start - 1);
			} else if (sum > N || end >= prime.size()) {
				start++;
				sum -= prime.get(start - 1);
			} else if (sum < N) {
				end++;
				sum += prime.get(end - 1);
			}
		}
		System.out.println(result);
	}

}
