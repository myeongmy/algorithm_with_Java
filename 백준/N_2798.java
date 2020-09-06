//백준 2798번 블랙잭
//브루트 포스

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2798 {
	static int[] A;
	static int[] result = new int[3];
	static int max = Integer.MIN_VALUE;

	static void go(int index, int selected, int M) {
		if (selected == 3) {
			int sum = 0;
			for (int i = 0; i < result.length; i++)
				sum += result[i];

			if (sum > M)
				return;
			if (max < sum)
				max = sum;
			return;
		}
		if (index >= A.length)
			return;

		result[selected] = A[index];
		go(index + 1, selected + 1, M);
		result[selected] = 0;

		go(index + 1, selected, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);

			A = new int[N];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(input[i]);
			}

			go(0, 0, M);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
