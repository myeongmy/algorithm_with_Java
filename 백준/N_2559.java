//백준 2559번 수열
//투 포인터(구간 구하기)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2559 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]); // 연속적인 날짜의 수
		int[] A = new int[N];

		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(arr[i]);

		int start = 0;
		int end = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		while (start <= A.length - K) {
			if (end - start == K - 1) {
				sum += A[end];
				// 최대값 비교
				if (max < sum)
					max = sum;
				sum = 0;
				start++;
				end = start;
			} else if (end - start < K - 1) {
				sum += A[end];
				end++;
			}
		}

		System.out.println(max);
	}

}
