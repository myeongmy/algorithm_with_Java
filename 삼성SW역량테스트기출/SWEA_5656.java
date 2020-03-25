//[���� SW�����׽�Ʈ] ���� ����
//���Ʈ ���� + �ùķ��̼� ����
/*������ ��� ������ ��Ʈ���� ������ �Ϸ��� �Ѵ�.

������ N���� �� �� �ְ�, �������� ������ �Ʒ��� ���� W x H �迭�� �־�����.

( 0 �� �� ������ �ǹ��ϸ�, �� ���� ���ڴ� ������ �ǹ��Ѵ�. )
 

 

������ ��Ģ�� ������ ����.

�� ������ ��, ��θ� ������ �� �־ �׻� �� ���� �ִ� ������ ��Ʈ�� �� �ִ�.

�� ������ ���� 1 ~ 9 �� ǥ���Ǹ�,

   ������ ������ ������ �����¿�� ( ������ ���� ���� - 1 ) ĭ ��ŭ ���� ���ŵȴ�.

 

�Ʒ��� ������ ���� ���ڿ�, ������ �������� �� ���ŵǴ� ������ ���̴�.


 

�� ���ŵǴ� ���� ���� �ִ� ������ ���ÿ� ���ŵȴ�.

 

���� ��� �Ʒ��� ���� 4 �� ������ ������ ������ ���,




9�� ������ 4 �� ������ �����Ͽ�,


 

���ÿ� ���ŵȴ�.

 

�� �� ������ ���� ��� ������ ������ �������� �ȴ�.



 

N ���� ������ ����Ʈ�� �ִ��� ���� ������ �����Ϸ��� �Ѵ�.

N, W, H, �׸��� �������� ������ �־��� ��,

�� ���� ������ ������ ���϶�!

 

�� sample input 1

 

N = 3, W = 10, K = 10 �̰� �������� ������ �Ʒ��� ���� ��,




�ִ��� ���� ������ ��Ʈ���� ����� �Ʒ��� ������, ������ 12 �� �ȴ�.

�׸��� ���� �� ���� ������ ������ ��ġ�̸�, ��Ȳ�� ĭ�� ������ ������ �ǹ��Ѵ�.

 

i) ù ��° ����



ii) �� ��° ����



iii) �� ��° ����

 

[���� ����]

1. 1 �� N �� 4

2. 2 �� W �� 12

3. 2 �� H �� 15

 
[�Է�]

���� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T �� �־�����,

�� ���� �ٺ��� T ���� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� N, W, H �� ������� ������ ���̿� �ΰ� �־�����,

���� H �ٿ� ���� �������� ������ 1 �ٿ� W ���� �־�����.



[���]

����� #t �� ��� �� ĭ ��� ���� ������ ����Ѵ�.

(t �� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1 ���� �����Ѵ�)*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;
import java.io.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class SWEA_5656 {
	static int[][] A;
	static int[] result = new int[5];
	static int min = Integer.MAX_VALUE;

	static void go(int index, int N) {
		if (index == N) {
			// �迭 ����
			int[][] B = new int[A.length][A[0].length];
			for (int i = 0; i < B.length; i++)
				B[i] = A[i].clone();

			Queue<Point> q = new LinkedList<Point>();

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				// 0�� �ƴ� �� ã��
				int j;
				for (j = 0; j < A.length; j++) {
					if (B[j][result[i]] != 0)
						break;
				}
				if (j == A.length)    //���� ó��: �� ���� ������ ��� �� �̻� �μ��� ���� ���
					continue;

				q.offer(new Point(j, result[i]));

				while (!q.isEmpty()) {
					Point p = q.poll();
					// ����� �� ã��
					// 1. ��
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.i - k < 0 || B[p.i - k][p.j] == 0)
							continue;
						q.offer(new Point(p.i - k, p.j));
					}
					// 2. ��
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.i + k >= B.length || B[p.i + k][p.j] == 0)
							continue;
						q.offer(new Point(p.i + k, p.j));
					}
					// 3.��
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.j - k < 0 || B[p.i][p.j - k] == 0)
							continue;
						q.offer(new Point(p.i, p.j - k));
					}
					// 4.��
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.j + k >= B[0].length || B[p.i][p.j + k] == 0)
							continue;
						q.offer(new Point(p.i, p.j + k));
					}

					// �ڽ� ����
					B[p.i][p.j] = 0;
				}
				// ������
				for (int m = A.length - 1; m >= 0; m--) {
					for (int n = 0; n < A[0].length; n++) {
						if (B[m][n] == 0)
							continue;
						int nextX = m + 1;

						while (true) {
							if (nextX >= A.length || B[nextX][n] != 0)
								break;
							nextX++;
						}
						if (nextX - 1 == m)
							continue;
						B[nextX - 1][n] = B[m][n];
						B[m][n] = 0;

					}
				}

			}
			for (int m = 0; m < B.length; m++) {
				for (int n = 0; n < B[0].length; n++) {
					if (B[m][n] != 0)
						cnt++;
				}
			}
			if (min > cnt)
				min = cnt;
			return;
		}
		for (int i = 0; i < A[0].length; i++) {
			result[index] = i;
			go(index + 1, N);
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");

				int N = Integer.parseInt(arr[0]);
				int W = Integer.parseInt(arr[1]);
				int H = Integer.parseInt(arr[2]);

				A = new int[H][W];
				for (int j = 0; j < H; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < W; k++) {
						A[j][k] = Integer.parseInt(arr1[k]);
					}
				}
				go(0, N);
				System.out.println("#" + (i + 1) + " " + min);
				min = Integer.MAX_VALUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
