//���� 1676��
/*����
N!���� �ڿ������� ó�� 0�� �ƴ� ���ڰ� ���� ������ 0�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. (0 �� N �� 500)

���
ù° �ٿ� ���� 0�� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int numOfZero = 0;
		for (int i = 1; Math.pow(5, (double) i) <= N; i++) {
			numOfZero += N / (int) Math.pow(5, (double) i);
		}
		System.out.println(numOfZero);
	}

}
