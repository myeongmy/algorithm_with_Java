//���� 1325��
//DFS ����
//�� ������ java�� �������ϸ� �ð� �ʰ�, java 11�� �������ϸ� ����Ǿ���. ������ ã�ƺ���!
/*����
��Ŀ �������� �� �˷��� ��� ȸ�縦 ��ŷ�Ϸ��� �Ѵ�. �� ȸ��� N���� ��ǻ�ͷ� �̷���� �ִ�. �������� ������ ������, �� ���� ��ŷ���� ���� ���� ��ǻ�͸� ��ŷ �� �� �ִ� ��ǻ�͸� ��ŷ�Ϸ��� �Ѵ�.

�� ȸ���� ��ǻ�ʹ� �ŷ��ϴ� �����, �ŷ����� �ʴ� ����� �̷���� �ִµ�, A�� B�� �ŷ��ϴ� ��쿡�� B�� ��ŷ�ϸ�, A�� ��ŷ�� �� �ִٴ� �Ҹ���.

�� ȸ���� ��ǻ���� �ŷ��ϴ� ���谡 �־����� ��, �� ���� ���� ���� ��ǻ�͸� ��ŷ�� �� �ִ� ��ǻ���� ��ȣ�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ�, N�� M�� ���´�. N�� 10,000���� �۰ų� ���� �ڿ���, M�� 100,000���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� M���� �ٿ� �ŷ��ϴ� ���谡 A B�� ���� �������� ������, "A�� B�� �ŷ��Ѵ�"�� �ǹ��Ѵ�. ��ǻ�ʹ� 1������ N������ ��ȣ�� �ϳ��� �Ű��� �ִ�.

���
ù° �ٿ�, �������� �� ���� ���� ���� ��ǻ�͸� ��ŷ�� �� �ִ� ��ǻ���� ��ȣ�� ������������ ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

public class N_1325 {
	static int connectedCom = 0;

	static void dfs(int v, ArrayList<Integer>[] adlist, int[] c) {
		c[v] = 1;
		connectedCom++;

		for (int a : adlist[v]) {
			if (c[a] == 0) {
				dfs(a, adlist, c);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);

			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adlist[i] = new ArrayList<Integer>();
			for (int i = 0; i < M; i++) {
				String[] arr1 = br.readLine().split(" ");
				int a = Integer.parseInt(arr1[0]);
				int b = Integer.parseInt(arr1[1]);
				adlist[b].add(a);
			}
			int[] num = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int[] c = new int[N + 1];
				connectedCom = 0;
				dfs(i, adlist, c);
				num[i] = connectedCom;
			}
			int max = 0;
			for (int i = 1; i <= N; i++) {
				if (max < num[i])
					max = num[i];
			}
			for (int i = 1; i <= N; i++) {
				if (num[i] == max)
					System.out.print(i + " ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
