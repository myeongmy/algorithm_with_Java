//���� 10824��
/*����
�� �ڿ��� A, B, C, D�� �־�����. �̶�, A�� B�� ���� ���� C�� D�� ���� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�� �� A�� B�� ��ġ�� ���� A�� �ڿ� B�� ���̴� ���� �ǹ��Ѵ�. ��, 20�� 30�� ���̸� 2030�� �ȴ�.

�Է�
ù° �ٿ� �� �ڿ��� A, B, C, D�� �־�����. (1 �� A, B, C, D �� 1,000,000)

���
A�� B�� ���� ���� C�� D�� ���� ���� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10824 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();
		int D = s.nextInt();

		long AB = Long.parseLong(Integer.toString(A) + Integer.toString(B));
		long CD = Long.parseLong(Integer.toString(C) + Integer.toString(D));

		System.out.println(AB + CD);

	}

}
