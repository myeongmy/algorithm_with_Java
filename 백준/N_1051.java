//���� 1051��
//���Ʈ ���� ����
/*����
N*Mũ���� ���簢���� �ִ�. �� ĭ�� �� �ڸ� ���ڰ� ���� �ִ�. �� ���簢������ �������� ���� �ִ� ���� ��� ���� ���� ū ���簢���� ã�� ���α׷��� �ۼ��Ͻÿ�. �̶�, ���簢���� �� �Ǵ� ���� �����ؾ� �Ѵ�.

�Է�
ù° �ٿ� N�� M�� �־�����. N�� M�� 50���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� N���� �ٿ� ���� �־�����.

���
ù° �ٿ� ���� ���簢���� ũ�⸦ ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

public class N_1051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);

			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					A[i][j] = str.charAt(j) - 48;
				}
			}

			int max_size = Integer.min(N, M);
			for (int i = max_size; i >= 2; i--) { // ���簢�� ũ��
				// �� �� �ִ� ��ġ
				for (int j = 0; j < N - (i - 1); j++) {
					for (int k = 0; k < M - (i - 1); k++) {
						if (A[j][k] == A[j + (i - 1)][k] && A[j][k] == A[j][k + (i - 1)]
								&& A[j][k] == A[j + (i - 1)][k + (i - 1)]) {
							System.out.println(i * i);
							System.exit(0);
						}
					}
				}

			}
			System.out.println(1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
