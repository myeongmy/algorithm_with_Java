//���� 1182��(��Ʈ����ũ)
/*����
N���� ������ �̷���� ������ ���� ��, ũ�Ⱑ ����� �κм��� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1 �� N �� 20, |S| �� 1,000,000) ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ������ 100,000�� ���� �ʴ´�.

���
ù° �ٿ� ���� S�� �Ǵ� �κм����� ������ ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_1182_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int S = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		int num = 0;
		for (long i = 1; i <= (1 << N) - 1; i++) { // ������ ��� ����� ��
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sum += A[j];
				}
			}
			if (sum == S)
				num++;
		}
		System.out.println(num);
	}

}
