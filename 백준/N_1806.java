//백준 1806번
//투 포인터 알고리즘 문제 풀이

package 백준;

import java.io.*;

public class N_1806 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			long S = Long.parseLong(input[1]);

			int[] A = new int[N];
			String[] arr = br.readLine().split(" ");

			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(arr[i]);

			long sum = 0;
			int start = 0;
			int end = 0;
			int result = 0;
			int min_length = Integer.MAX_VALUE;

			while (start < N) {
				if (sum >= S || end >= N) {
					if (sum >= S) {
						result++;
						if (min_length > end - start)
							min_length = end - start;
					}

					start++;
					sum -= A[start - 1];

				} else if (sum < S) {
					end++;
					sum += A[end - 1];
				}
			}

			if (result == 0)
				System.out.println(0);
			else
				System.out.println(min_length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
