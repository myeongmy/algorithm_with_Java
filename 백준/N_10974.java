//���� 10974��
/*����
N�� �־����� ��, 1���� N������ ���� �̷���� ������ ���������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N(1 �� N �� 8)�� �־�����. 

���
ù° �ٺ��� N!���� �ٿ� ���ļ� ��� ������ ���������� ����Ѵ�.*/

package ����;

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
