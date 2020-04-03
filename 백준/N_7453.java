//백준 7453번
//이분탐색 문제 풀이
/*문제
정수로 이루어진 크기가 같은 배열 A, B, C, D가 있다.

A[a], B[b], C[c], D[d]의 합이 0인 (a, b, c, d) 쌍의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 배열의 크기 n (1 ≤ n ≤ 4000)이 주어진다. 다음 n개 줄에는 A, B, C, D에 포함되는 정수가 공백으로 구분되어져서 주어진다. 배열에 들어있는 정수의 절댓값은 최대 228이다.

출력
합이 0이 되는 쌍의 개수를 출력한다.*/

package 백준;

import java.io.*;
import java.util.*;

public class N_7453 {
	static int[] A;
	static int[] B;
	static int[] C;
	static int[] D;
	static ArrayList<Integer> first = new ArrayList<Integer>(); // 앞 두 그룹 가능한 합 집합
	static ArrayList<Integer> second = new ArrayList<Integer>();
	static int[] result = new int[2];

	static void go(int index) {
		if (index == 2) {
			int sum = result[0] + result[1];

			first.add(sum);
			return;
		}
		if (index == 0) {
			for (int i = 0; i < A.length; i++) {
				result[index] = A[i];
				go(index + 1);
				result[index] = 0;
			}
		} else if (index == 1) {
			for (int i = 0; i < B.length; i++) {
				result[index] = B[i];
				go(index + 1);
				result[index] = 0;
			}
		}
	}

	static void go1(int index) {
		if (index == 2) {
			int sum = result[0] + result[1];

			second.add(sum);
			return;
		}
		if (index == 0) {
			for (int i = 0; i < C.length; i++) {
				result[index] = C[i];
				go1(index + 1);
				result[index] = 0;
			}
		} else if (index == 1) {
			for (int i = 0; i < D.length; i++) {
				result[index] = D[i];
				go1(index + 1);
				result[index] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());

			A = new int[n];
			B = new int[n];
			C = new int[n];
			D = new int[n];

			for (int i = 0; i < n; i++) {
				String[] arr = br.readLine().split(" ");

				A[i] = Integer.parseInt(arr[0]);
				B[i] = Integer.parseInt(arr[1]);
				C[i] = Integer.parseInt(arr[2]);
				D[i] = Integer.parseInt(arr[3]);
			}

			go(0); // A와 B
			go1(0); // C와 D

			Collections.sort(first);
			Collections.sort(second);

			// 두 포인터
			int leftpo = 0;
			int rightpo = second.size() - 1;
			long cnt = 0;

			while (leftpo < first.size() && rightpo >= 0) {
				if (first.get(leftpo) + second.get(rightpo) > 0) {
					rightpo--;
				} else if (first.get(leftpo) + second.get(rightpo) == 0) { // 중복 값 처리
					int temp = first.get(leftpo);
					int temp1 = second.get(rightpo);

					long lcnt = 0;
					while (leftpo < first.size() && temp == first.get(leftpo)) {
						leftpo++;
						lcnt++;
					}

					long rcnt = 0;
					while (rightpo >= 0 && temp1 == second.get(rightpo)) {
						rightpo--;
						rcnt++;
					}

					cnt += lcnt * rcnt;
				} else if (first.get(leftpo) + second.get(rightpo) < 0) {
					leftpo++;
				}
			}
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
