//���� 10952��
/*
 ����
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)

�Է��� ���������� 0 �� ���� ���´�.

���
�� �׽�Ʈ ���̽����� A+B�� ����Ѵ�.
*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int A = s.nextInt();
			int B = s.nextInt();
			if (A == 0 && B == 0)
				break;
			System.out.println(A + B);
		}
	}

}
