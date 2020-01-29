//���� 1707��
/*����
�׷����� ������ ������ �ѷ� �����Ͽ�, �� ���տ� ���� ���������� ���� �������� �ʵ��� ������ �� ���� ��, �׷��� �׷����� Ư���� �̺� �׷��� (Bipartite Graph) �� �θ���.

�׷����� �Է����� �־����� ��, �� �׷����� �̺� �׷������� �ƴ��� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �����Ǿ� �ִµ�, ù° �ٿ� �׽�Ʈ ���̽��� ���� K(2��K��5)�� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� �׷����� ������ ���� V(1��V��20,000)�� ������ ���� E(1��E��200,000)�� �� ĭ�� ���̿� �ΰ� ������� �־�����. �� �������� 1���� V���� ���ʷ� ��ȣ�� �پ� �ִ�. �̾ ��° �ٺ��� E���� �ٿ� ���� ������ ���� ������ �־����µ�, �� �ٿ� ������ �� ������ ��ȣ�� �� ĭ�� ���̿� �ΰ� �־�����.

���
K���� �ٿ� ���� �Է����� �־��� �׷����� �̺� �׷����̸� YES, �ƴϸ� NO�� ������� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1707 {

	static void dfs(int v, int color, ArrayList<Integer>[] adlist, int[] c) {
		if (c[v] != 0)
			return;
		c[v] = color;

		for (int a : adlist[v]) {
			if (c[a] == 0)
				dfs(a, 3 - color, adlist, c);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int V = s.nextInt();
			int E = s.nextInt();
			int[] c = new int[20001];
			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[V + 1];
			for (int j = 1; j <= V; j++)
				adlist[j] = new ArrayList<Integer>();
			for (int j = 0; j < E; j++) {
				int a = s.nextInt();
				int b = s.nextInt();
				adlist[a].add(b);
				adlist[b].add(a);
			}
			for (int z = 1; z <= V; z++) {
				if (c[z] == 0)
					dfs(z, 1, adlist, c);
			}

			int flag = 0;
			Label: for (int k = 1; k <= V; k++) {
				for (int w = 0; w < adlist[k].size(); w++) {
					if (c[k] == c[adlist[k].get(w)]) {
						flag = 1;
						break Label;
					}
				}
			}
			if (flag == 1)
				System.out.println("NO");
			else
				System.out.println("YES");

		}

	}

}
