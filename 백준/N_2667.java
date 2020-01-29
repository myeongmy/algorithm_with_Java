//���� 2667��
/*����
<�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����. ö���� �� ������ ������ ����� ������ ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. ���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. �밢���� ���� �ִ� ���� ����� ���� �ƴϴ�. <�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�. ������ �Է��Ͽ� �������� ����ϰ�, �� ������ ���ϴ� ���� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.



�Է�
ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.

���
ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ������ ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.*/

package ����;

import java.io.*;
import java.util.*;

public class N_2667 {
	static int[][] c = new int[30][30];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int numOfHome = 0;

	static void dfs(int i, int j, int[][] A) {
		c[i][j] = 1;
		numOfHome++;
		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A.length) {
				if (A[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0)
					dfs(i + dx[k], j + dy[k], A);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] A = new int[N + 1][N + 1];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					A[i][j] = str.charAt(j) - 48;
				}
			}
			int connectedCompo = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (A[i][j] == 1 && c[i][j] == 0) {
						dfs(i, j, A);
						list.add(numOfHome);
						numOfHome = 0;
						connectedCompo++;
					}
				}
			}
			System.out.println(connectedCompo);
			Collections.sort(list); // ������ ���Ծ Ʋ�Ⱦ���!!
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
