//���� 3085��
/*����
����̴� ����� ���� "������ (Bomboni)" ������ ����ߴ�.

���� ó���� N��Nũ�⿡ ������ ä�� ���´�. ������ ���� ��� ���� ���� ���� �ִ�. ����̴� ������ ���� �ٸ� ������ �� ĭ�� ����. �� ���� �� ĭ�� ����ִ� ������ ���� ��ȯ�Ѵ�. ����, ��� ���� ������ �̷���� �ִ� ���� �� ���� �κ�(�� �Ǵ� ��)�� �� ���� �� ������ ��� �Դ´�.

������ ä���� ���°� �־����� ��, ����̰� ���� �� �ִ� ������ �ִ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ũ�� N�� �־�����. (3 �� N �� 50)

���� N�� �ٿ��� ���忡 ä���� �ִ� ������ ������ �־�����. �������� C, �Ķ����� P, �ʷϻ��� Z, ������� Y�� �־�����.

������ ���� �ٸ� ������ �� ĭ�� �����ϴ� �Է¸� �־�����.

���
ù° �ٿ� ����̰� ���� �� �ִ� ������ �ִ� ������ ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_3085 {
	static int check(char[][] A) {
		int cnt;
		int result = 1;
		for (int k = 0; k < A.length; k++) {
			cnt = 1; // ������ ����!!!! �� �� �ٲ� ������ 1�� �ʱ�ȭ���־����!
			for (int m = 0; m < A.length-1; m++) {
				if (A[k][m] == A[k][m + 1])
					cnt++;
				else
					cnt = 1;
				if (result < cnt) 
					result = cnt;
				
			}
		}
		
		for (int k = 0; k < A.length; k++) {
			cnt = 1;
			for (int m = 0; m < A.length-1; m++) {
				if (A[m][k] == A[m + 1][k])
					cnt++;
				else
					cnt = 1;
				if (result < cnt) 
					result = cnt;
					
				
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		s.nextLine();
		char[][] A = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = s.nextLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = str.charAt(j);
			}
		}

		int result = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != N - 1) {
					char temp;
					temp = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = temp;

					int num = check(A);
					
					if (result < num)
						result = num;
					temp = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = temp;

				}
				if (i != N - 1) {
					char temp = A[i][j];
					A[i][j] = A[i + 1][j];
					A[i + 1][j] = temp;

					int num = check(A);
					if (result < num)
						result = num;
					temp = A[i][j];
					A[i][j] = A[i + 1][j];
					A[i + 1][j] = temp;
				}
			}
		}
		System.out.println(result);

	}

}
