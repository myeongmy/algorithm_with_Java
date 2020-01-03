//���� 1929��
/*����
M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000)

���
�� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();
		boolean[] check = new boolean[N + 1]; // �Ҽ��� �ƴϸ� true
		check[0] = true;
		check[1] = true;
		for (int i = 2; i <= N; i++) {
			if (check[i] == false) {
				for (int j = 2; i * j <= N; j++) {
					check[i * j] = true;
				}
			}
		}
		for (int i = M; i <= N; i++) {
			if (check[i] == false)
				System.out.println(i);
		}
	}

}
