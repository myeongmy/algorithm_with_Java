//[���� SW �����׽�Ʈ] ���� ����
// dfs(��� ã��) + ���� Ž�� ����
/*���θ� �����Ϸ��� �Ѵ�.

���θ� ����� ���� ������ N * N ũ�⸦ ������ ������, �̰��� �ִ��� �� ���θ� ���� ��ȹ�̴�.

���� ������ �Ʒ� [Fig. 1]�� ���� ���ڰ� ǥ�õ� ������ �־�����, �� ���ڴ� ������ ���̸� ��Ÿ����.
 

 

���θ� ����� ��Ģ�� ������ ����.

   �� ���δ� ���� ���� ���츮���� �����ؾ� �Ѵ�.

   �� ���δ� ������ �ö� �� �ֵ��� �ݵ�� ���� �������� ���� �������� ���� �Ǵ� ���� �������� ������ �Ǿ�� �Ѵ�.
       ��, ���̰� ���� �� Ȥ�� ���� �����̳�, �밢�� ������ ������ �Ұ����ϴ�.

   �� �� ���θ� ����� ���� �� �� ���� ���ؼ� �ִ� K ���̸�ŭ ������ ��� ���縦 �� �� �ִ�.

N * N ũ���� ������ �־�����, �ִ� ���� ���� ���� K�� �־�����.

�̶� ���� �� �ִ� ���� �� ���θ� ã�� �� ���̸� ����ϴ� ���α׷��� �ۼ��϶�.


[����]

�� [Fig. 1]�� ���� N = 5�� ������ �־��� ��츦 ���캸��.

���� ���� ���츮�� ���̰� 9�� ǥ�õ� �� �����̴�.

�� �� ������ ����ϴ� ���� �� ���� �� �ϳ��� �Ʒ� [Fig. 2]�� ����, �� �� ���̴� 5�� �ȴ�.
 
 

���� �ִ� ���� ���� ���� K = 1�� �־��� ���,

�Ʒ� [Fig. 3]�� ���� ������ �κ��� ���̸� 9���� 8�� ������ ���̰� 6�� ���θ� ���� �� �ִ�.
 


�� ������ ���� �� �ִ� ���� �� ���δ� ���� ������, ����� ������ 6�� �ȴ�.


[���� ����]

1. �ð� ���� : �ִ� 50�� �׽�Ʈ ���̽��� ��� ����ϴ� �� C/C++/Java ��� 3��

2. ������ �� ���� ���� N�� 3 �̻� 8 ������ �����̴�. (3 �� N �� 8)

3. �ִ� ���� ���� ���� K�� 1 �̻� 5 ������ �����̴�. (1 �� K �� 5)

4. ������ ��Ÿ���� ������ ���̴� 1 �̻� 20 ������ �����̴�.

5. �������� ���� ���� ���츮�� �ִ� 5���̴�.

6. ������ ���� �����θ� ���� �� �ִ�.

7. �ʿ��� ��� ������ ��� ���̸� 1���� �۰� ����� �͵� �����ϴ�.

[�Է�]

�Է��� �� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־�����, �� ���� �ٺ��� T���� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ������ �� ���� ���� N, �ִ� ���� ���� ���� K�� ���ʷ� �־�����.

�� ���� N���� �ٿ��� N * N ũ���� ���� ������ �־�����.

[���]

�׽�Ʈ ���̽� ������ŭ T���� �ٿ� ������ �׽�Ʈ ���̽��� ���� ���� ����Ѵ�.

�� ���� "#t"�� �����ϰ� ������ �ϳ� �� ���� ������ ����Ѵ�. (t�� 1���� �����ϴ� �׽�Ʈ ���̽��� ��ȣ�̴�)

����ؾ� �� ������ ���� �� �ִ� ���� �� ������ �����̴�.*/

package �ＺSW�����׽�Ʈ����;

import java.io.*;
import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class SWEA_1949 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int length = 0;
	static int totalmax = Integer.MIN_VALUE;
	static LinkedList<Integer> list = new LinkedList<Integer>();

	static void dfs(int i, int j, int[][] c, int[][] A) {
		if (length > 0) {
			if (totalmax < length) {
				totalmax = length;
			}
		}
		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A.length) {
				if (A[i + dx[k]][j + dy[k]] < A[i][j] && c[i + dx[k]][j + dy[k]] == 0) {
					c[i + dx[k]][j + dy[k]] = 1;
					list.add(A[i + dx[k]][j + dy[k]]);
					length++;
					dfs(i + dx[k], j + dy[k], c, A);
					c[i + dx[k]][j + dy[k]] = 0;
					list.remove(list.size() - 1);
					length--;
				}
			}
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
				int K = Integer.parseInt(arr[1]);

				int[][] A = new int[N][N];
				LinkedList<Point> q = new LinkedList<Point>(); // �ְ� ���츮 ��ġ ����
				int max = A[0][0];

				for (int j = 0; j < N; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr1[k]);
						if (max < A[j][k])
							max = A[j][k];
					}
				}
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (A[j][k] == max)
							q.offer(new Point(j, k));
					}
				}
				// ����Ž��
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						for (int m = 1; m <= K; m++) {
							A[j][k] -= m; // m��ŭ ���츮 ���
							// dfs
							for (int n = 0; n < q.size(); n++) {
								Point p = q.get(n);
								if (p.i == j && p.j == k)
									continue;
								int[][] c = new int[N][N];
								c[p.i][p.j] = 1;
								length = 1;
								dfs(p.i, p.j, c, A);
							}
							A[j][k] += m;
						}
					}
				}
				System.out.println("#" + (i + 1) + " " + totalmax);
				totalmax = Integer.MIN_VALUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
