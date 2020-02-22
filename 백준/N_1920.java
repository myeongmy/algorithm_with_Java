//백준 1920번
//이진 탐색 문제
/*문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1≤N≤100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1≤M≤100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수들의 범위는 int 로 한다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.*/

package 백준;

import java.util.*;

public class N_1920 {
	static int binarySearch(int key, int start, int end, int[] A) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		if (A[mid] > key)
			return binarySearch(key, start, mid - 1, A);
		else if (A[mid] < key)
			return binarySearch(key, mid + 1, end, A);
		else
			return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		Arrays.sort(A);
		// 1. 표준 라이브러리를 이용한 구현

		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			int key = s.nextInt();
			if (Arrays.binarySearch(A, key) < 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

		// 2.직접 구현
		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			int key = s.nextInt();
			int result = binarySearch(key, 0, A.length - 1, A);

			if (result == -1)
				System.out.println(0);
			else
				System.out.println(1);

		}

	}

}
