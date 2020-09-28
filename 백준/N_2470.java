//백준 2470번 두 용액
//투 포인터 알고리즘

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_2470 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(arr[i]);

		Arrays.sort(A);
		int start = 0;
		int end = A.length - 1;
		long result = Integer.MAX_VALUE;
		int answer1 = 0;
		int answer2 = 0;

		while (start != end) {
			if (result > Math.abs(A[end] + A[start])) {
				result = Math.abs(A[end] + A[start]);
				answer1 = A[start];
				answer2 = A[end];
			}

			if (Math.abs(A[start] + A[end - 1]) < Math.abs(A[start + 1] + A[end])) {
				end--;
			} else {
				start++;
			}

		}

		System.out.println(answer1 + " " + answer2);
	}

}
