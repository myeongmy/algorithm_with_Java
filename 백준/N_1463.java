//���� 1463��
/*����
���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.

�Է�
ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� ���� N�� �־�����.

���
ù° �ٿ� ������ �ϴ� Ƚ���� �ּڰ��� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] d = new int[N+1]; // d[N] : N�� 1�� ����� ���� ���� �ּ� Ƚ��

		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 2 == 0 && d[i] > d[i/2]+1)
				d[i] = d[i / 2] + 1;
			if (i % 3 == 0 && d[i] > d[i/3]+1)
				d[i] = d[i / 3] + 1;
		}
		System.out.println(d[N]);
	}

}
