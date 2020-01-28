//���� 1182��(���)
/*����
N���� ������ �̷���� ������ ���� ��, ũ�Ⱑ ����� �κм��� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1 �� N �� 20, |S| �� 1,000,000) ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ������ 100,000�� ���� �ʴ´�.

���
ù° �ٿ� ���� S�� �Ǵ� �κм����� ������ ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_1182 {
	static int[] result = new int[21];
	static int num = 0;

	static void go(int index, int selected, int[] A, int N, int S) {
		if (index == N) {
			if (selected >= 1) {
				int sum = 0;
				for (int i = 0; i < index; i++)
					sum += result[i];
				if (sum == S)
					num++;
			}
			return;
		}
		result[selected] = A[index];
		go(index + 1, selected + 1, A, N, S);
		result[selected] = 0;

		go(index + 1, selected, A, N, S);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int S = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		go(0, 0, A, N, S);
		System.out.println(num);
	}

}
