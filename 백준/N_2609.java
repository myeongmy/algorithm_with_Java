//���� 2609��
/*����
�� ���� �ڿ����� �Է¹޾� �ִ� ������� �ּ� ������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� �� ���� �ڿ����� �־�����. �� ���� 10,000������ �ڿ����̸� ���̿� �� ĭ�� ������ �־�����.

���
ù° �ٿ��� �Է����� �־��� �� ���� �ִ�������,��° �ٿ��� �Է����� �־��� �� ���� �ּ� ������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_2609 {

	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int G = GCD(A, B);
		int L = A * B / G;
		System.out.println(G);
		System.out.println(L);
	}

}
