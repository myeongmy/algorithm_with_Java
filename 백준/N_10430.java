//���� 10430��
/*����
(A+B)%C�� (A%C + B%C)%C �� ������?

(A��B)%C�� (A%C �� B%C)%C �� ������?

�� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� A, B, C�� ������� �־�����. (2 �� A, B, C �� 10000)

���
ù° �ٿ� (A+B)%C, ��° �ٿ� (A%C + B%C)%C, ��° �ٿ� (A��B)%C, ��° �ٿ� (A%C �� B%C)%C�� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10430 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();
		System.out.println((A + B) % C);
		System.out.println((A % C + B % C) % C);
		System.out.println((A * B) % C);
		System.out.println((A % C * B % C) % C);
	}

}
