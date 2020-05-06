//백준 2003번
//투 포인터 알고리즘 문제 풀이

package 백준;

import java.util.*;

public class N_2003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long M = s.nextLong();

		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();

		long sum = 0;
		int start = 0;
		int end = 0;
		int result = 0;

		while (start < N) {
			if (sum == M) {
				result++;
				start++;
				sum -= A[start - 1];
			} else if (sum > M || end >= N) {
				start++;
				sum -= A[start - 1];
			} else if (sum < M) {
				end++;
				sum += A[end - 1];
			}
		}
		System.out.println(result);
	}

}
