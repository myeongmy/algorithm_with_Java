//백준 10816번 숫자 카드 2
//이분 탐색

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_10816 {
	static int[] A;
	static int cnt = 0;

	static void binarySearch(int start, int end, int target) {
		if (start > end)
			return;

		int mid = (start + end) / 2;

		if (A[mid] == target) {
			cnt++;
			binarySearch(start, mid - 1, target);
			binarySearch(mid + 1, end, target);
		} else if (A[mid] > target)
			binarySearch(start, mid - 1, target);
		else if (A[mid] < target)
			binarySearch(mid + 1, end, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			A = new int[N];
			String[] arr = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(arr[i]);
			}

			Arrays.sort(A);

			int M = Integer.parseInt(br.readLine());
			arr = br.readLine().split(" ");
			int[] B = new int[M];
			int[] freq = new int[M];

			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(arr[i]);
				binarySearch(0, N - 1, B[i]);
				freq[i] = cnt;
				cnt = 0;
			}

			for (int i = 0; i < freq.length; i++)
				System.out.print(freq[i] + " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
