//���� 10872��
/*����
0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.

���
ù° �ٿ� N!�� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int factorial = 1;
		for (int i = 1; i <= N; i++)
			factorial *= i;
		System.out.println(factorial);
	}

}
