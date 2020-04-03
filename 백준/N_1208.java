//백준 1208번
//이분탐색 문제 풀이
/*문제
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 40, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

public class N_1208 {
	static int[] A;
	static int[] result = new int[40];
	static ArrayList<Integer> first = new ArrayList<Integer>();
	static ArrayList<Integer> second = new ArrayList<Integer>();

	static void go(int index, int selected, int last) {
		if (index > last) {
			int sum = 0;
			for (int i = 0; i < selected; i++) {
				sum += result[i];
			}
			first.add(sum);
			return;
		}
		result[selected] = A[index];
		go(index + 1, selected + 1, last);
		result[selected] = 0;

		go(index + 1, selected, last);
	}

	static void go1(int index, int selected, int start) {
		if (start + index == A.length) {
			int sum = 0;
			for (int i = 0; i < selected; i++)
				sum += result[i];
			second.add(sum);
			return;
		}
		result[selected] = A[start + index];
		go1(index + 1, selected + 1, start);
		result[selected] = 0;

		go1(index + 1, selected, start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int S = Integer.parseInt(arr[1]);

			A = new int[N];
			String[] arr1 = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(arr1[i]);
			}
			go(0, 0, N / 2);
			go1(0, 0, N / 2 + 1);

			Collections.sort(first);
			Collections.sort(second);

			int leftpo = 0;
			int rightpo = second.size() - 1;

			long cnt = 0;
			while (leftpo < first.size() && rightpo >= 0) {
				if (first.get(leftpo) + second.get(rightpo) > S) {
					rightpo--;
				} else if (first.get(leftpo) + second.get(rightpo) == S) {    //중복 값 처리
					int temp = first.get(leftpo);
					int temp1 = second.get(rightpo);

					long lcnt = 0;
					while (leftpo < first.size() && first.get(leftpo) == temp) {
						leftpo++;
						lcnt++;
					}

					long rcnt = 0;
					while (rightpo >= 0 && second.get(rightpo) == temp1) {
						rightpo--;
						rcnt++;
					}
					cnt += lcnt * rcnt;
				} else if (first.get(leftpo) + second.get(rightpo) < S) {
					leftpo++;
				}
			}
			if (S == 0)
				cnt--;
			System.out.println(cnt);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
