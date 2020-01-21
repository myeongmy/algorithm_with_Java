//���� 14500��
/*����
�������̳�� ũ�Ⱑ 1��1�� ���簢���� ���� �� �̾ ���� �����̸�, ������ ���� ������ �����ؾ� �Ѵ�.

���簢���� ���� ��ġ�� �� �ȴ�.
������ ��� ����Ǿ� �־�� �Ѵ�.
���簢���� ������ ����Ǿ� �־�� �Ѵ�. ��, �������� �������� �´�� ������ �� �ȴ�.
���簢�� 4���� �̾� ���� �������̳�� ��Ʈ�ι̳��� �ϸ�, ������ ���� 5������ �ִ�.



�Ƹ��̴� ũ�Ⱑ N��M�� ���� ���� ��Ʈ�ι̳� �ϳ��� �������� �Ѵ�. ���̴� 1��1 ũ���� ĭ���� �������� ������, ������ ĭ���� ������ �ϳ� ���� �ִ�.

��Ʈ�ι̳� �ϳ��� ������ ���Ƽ� ��Ʈ�ι̳밡 ���� ĭ�� ���� �ִ� ������ ���� �ִ�� �ϴ� ���α׷��� �ۼ��Ͻÿ�.

��Ʈ�ι̳�� �ݵ�� �� ���簢���� ��Ȯ�� �ϳ��� ĭ�� �����ϵ��� ���ƾ� �ϸ�, ȸ���̳� ��Ī�� ���ѵ� �ȴ�.

�Է�
ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (4 �� N, M �� 500)

��° �ٺ��� N���� �ٿ� ���̿� ���� �ִ� ���� �־�����. i��° ���� j��° ���� ���������� i��° ĭ, ���ʿ������� j��° ĭ�� ���� �ִ� ���̴�. �Է����� �־����� ���� 1,000�� ���� �ʴ� �ڿ����̴�.

���
ù° �ٿ� ��Ʈ�ι̳밡 ���� ĭ�� ���� ������ ���� �ִ��� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_14500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		int result = 0;
		// 1��° ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 3; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
				if (result < num)
					result = num;
			}
		}

		// 2��° ���
		for (int i = 0; i < N - 3; i++) {
			for (int j = 0; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
				if (result < num)
					result = num;
			}
		}

		// 3��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 4��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}

		// 5��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 6��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1];
				if (result < num)
					result = num;
			}
		}

		// 7��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j];
				if (result < num)
					result = num;
			}
		}

		// 8��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 9��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 10��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 2; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 1][j - 2];
				if (result < num)
					result = num;
			}
		}

		// 11��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 12��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 13��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1];
				if (result < num)
					result = num;
			}
		}

		// 14��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 2; j < M; j++) {
				int num = arr[i][j] + arr[i][j - 1] + arr[i + 1][j - 1] + arr[i + 1][j - 2];
				if (result < num)
					result = num;
			}
		}

		// 15��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				if (result < num)
					result = num;
			}
		}

		// 16��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 2; j++) {
				int num = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 17��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < M; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}

		// 18��° ���
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if (result < num)
					result = num;
			}
		}

		// 19��° ���
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 1; j++) {
				int num = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j];
				if (result < num)
					result = num;
			}
		}
		System.out.println(result);
	}

}
