//���� 2004��
/*����
nCm�� ���ڸ� 0�� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� n, m(0��m��n��2,000,000,000, n!=0)�� ���´�.

���
ù° �ٿ� 0�� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_2004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int numOfTwo = 0;
		int numOfFive = 0;

		for (int i = 1; Math.pow(2, i) <= n; i++) { // n!�� 2�� ���� ���ϱ�
			numOfTwo += n / (int) Math.pow(2, i);
		}
		for (int i = 1; Math.pow(2, i) <= n - m; i++) { // (n-m)!�� 2�� ���� ���ϱ�
			numOfTwo -= (n - m) / (int) Math.pow(2, i);
		}
		for (int i = 1; Math.pow(2, i) <= m; i++) { // m!�� 2�� ���� ���ϱ�
			numOfTwo -= m / (int) Math.pow(2, i);
		}

		for (int i = 1; Math.pow(5, i) <= n; i++) { // n!�� 5�� ���� ���ϱ�
			numOfFive += n / (int) Math.pow(5, i);
		}
		for (int i = 1; Math.pow(5, i) <= n - m; i++) { // (n-m)!�� 5�� ���� ���ϱ�
			numOfFive -= (n - m) / (int) Math.pow(5, i);
		}
		for (int i = 1; Math.pow(2, i) <= m; i++) { // m!�� 5�� ���� ���ϱ�
			numOfFive -= m / (int) Math.pow(5, i);
		}
		if (numOfTwo <= numOfFive)
			System.out.println(numOfTwo);
		else
			System.out.println(numOfFive);
	}

}
