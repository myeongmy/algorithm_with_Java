// Ÿ�� ��ĥ�ϱ�
// 2x2 �����̷� ���ϴ� ����� ���� �� ������ YES, �ƴϸ� NO
// ������ ����Ž�� ����

package �ڵ��׽�Ʈ;

import java.util.*;

public class SW_Maestro_Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt(); // 1�� ��ĥ�ؾ��� ��, 0�� �ƴ� ��
			}
		}

		int[][] B = new int[N][M];
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (A[i][j] == 1 && A[i][j + 1] == 1 && A[i + 1][j] == 1 && A[i + 1][j + 1] == 1) {
					B[i][j] = 1;
					B[i + 1][j] = 1;
					B[i][j + 1] = 1;
					B[i + 1][j + 1] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");
	}

}
