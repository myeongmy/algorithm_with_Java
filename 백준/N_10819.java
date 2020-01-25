//백준 10819번
/*문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_10819 {
	static boolean[] c = new boolean[10];
	static int[] result = new int[10];
	static int maxResult = 0;

	static void go(int index, int[] A, int N) {
		if (index == N) {
			int num = 0;
			for (int i = 0; i <= N - 2; i++) {
				num += Math.abs(result[i] - result[i + 1]);
			}
			if (maxResult < num)
				maxResult = num;
		}
		for (int i = 0; i < A.length; i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			result[index] = A[i];
			go(index + 1, A, N);
			c[i] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		go(0, A, N);
		System.out.println(maxResult);
	}

}
