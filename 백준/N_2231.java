//���� 2231��
//���Ʈ ���� ����(�׳� �� �غ���)
/*����
� �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�. � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�. ���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�. ���� 245�� 256�� �����ڰ� �ȴ�. ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�. �ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.

�ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)�� �־�����.

���
ù° �ٿ� ���� ����Ѵ�. �����ڰ� ���� ��쿡�� 0�� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 1; i < N; i++) {
			String str = Integer.toString(i);
			int num = i;
			for (int j = 0; j < str.length(); j++)
				num += str.charAt(j) - 48;
			if (N == num) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(0);
	}

}
