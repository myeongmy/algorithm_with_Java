//���� 10819��
/*����
N���� ������ �̷���� �迭 A�� �־�����. �̶�, �迭�� ����ִ� ������ ������ ������ �ٲ㼭 ���� ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

�Է�
ù° �ٿ� N (3 �� N �� 8)�� �־�����. ��° �ٿ��� �迭 A�� ����ִ� ������ �־�����. �迭�� ����ִ� ������ -100���� ũ�ų� ����, 100���� �۰ų� ����.

���
ù° �ٿ� �迭�� ����ִ� ���� ������ ������ �ٲ㼭 ���� �� �ִ� ���� �ִ��� ����Ѵ�.*/

package ����;

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
