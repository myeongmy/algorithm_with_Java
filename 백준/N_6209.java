//백준 6209번 제자리 멀리뛰기
//이분탐색(파라메트릭 서치)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_6209 {
	static int[] A;
	static int max = Integer.MIN_VALUE;

	static void binarySearch(int start, int end, int m) {
		if (start > end)
			return;

		int mid = (start + end) / 2;

		int removeNum = 0;
		int pos = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] - A[pos] < mid)
				removeNum++;
			else
				pos = i;
		}

		if (removeNum > m) {
			binarySearch(start, mid - 1, m);
		} else if (removeNum <= m) {
			if (max < mid)
				max = mid;
			binarySearch(mid + 1, end, m);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int d = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]); // 돌섬의 수
			int m = Integer.parseInt(input[2]); // 제거할 수 있는 돌섬의 수

			A = new int[n + 2];
			A[0] = 0;
			for (int i = 1; i <= n; i++) {
				A[i] = Integer.parseInt(br.readLine());
			}
			A[n + 1] = d;
			Arrays.sort(A);

			binarySearch(0, d, m);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
