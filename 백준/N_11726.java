//���� 11726��
/*����
2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Ʒ� �׸��� 2��5 ũ���� ���簢���� ä�� �� ���� ����� ���̴�.



�Է�
ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)

���
ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
*/
package codingtest_study.����;

import java.util.Scanner;

public class N_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] d = new int[n + 1];

		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] = d[i] % 10007;
		}
		System.out.println(d[n]);
	}

}
