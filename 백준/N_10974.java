//백준 10974번
/*문제
N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다. 

출력
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_10974 {
	static boolean[] c = new boolean[10];
	static int[] result = new int[10];

	static void go(int index, int N) {
		if (index == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			result[index] = i;
			go(index + 1, N);
			c[i] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		go(0, N);
	}

}
