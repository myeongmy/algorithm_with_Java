//백준 1806번 부분합
//구간을 구하는 것이므로 투포인터 알고리즘 이용

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1806_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 배열의 길이
			int M = Integer.parseInt(input[1]); // S

			String[] arr = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(arr[i]);

			int start = 0;
			int end = 0;
			long sum = 0;
			long min_length = Long.MAX_VALUE;

			while (start < N) {
				if (sum >= M || end >= N) {
					if (sum >= M && min_length > (end - start))
						min_length = (end - start);

					sum -= A[start];
					start++;
				} else if (sum < M) {
					sum += A[end];
					end++;
				}
			}

			if (min_length == Long.MAX_VALUE)
				System.out.println(0);
			else
				System.out.println(min_length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
