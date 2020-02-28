//���� 1167��
/*����
Ʈ���� �����̶�, Ʈ������ ������ �� �� ������ �Ÿ� �� ���� �� ���� ���Ѵ�. Ʈ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
Ʈ���� �Է����� �־�����. ���� ù ��° �ٿ����� Ʈ���� ������ ���� V�� �־����� (2��V��100,000)��° �ٺ��� V���� �ٿ� ���� ������ ������ ������ ���� �־�����. (���� ��ȣ�� 1���� V���� �Ű��� �ִٰ� �����Ѵ�)

���� ���� ��ȣ�� �־�����, �̾ ����� ������ ������ �ǹ��ϴ� ������ �� ���� �־����µ�, �ϳ��� ������ȣ, �ٸ� �ϳ��� �� ���������� �Ÿ��̴�. ���� ��� �� ��° ���� ��� ���� 3�� ���� 1�� �Ÿ��� 2�� �������� ����Ǿ� �ְ�, ���� 4�ʹ� �Ÿ��� 3�� �������� ����Ǿ� �ִ� ���� �����ش�. �� ���� ���������� -1�� �Է����� �־�����. �־����� �Ÿ��� ��� 10,000 ������ �ڿ����̴�.

���
ù° �ٿ� Ʈ���� ������ ����Ѵ�.*/

package ����;

import java.util.*;

class Node1 {
	int v;
	int weight;

	Node1(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
}

public class N_1167 {
	static ArrayList<Node1>[] adlist;

	static void dfs(int v, int[] c, int[] depth) {
		c[v] = 1;

		for (Node1 n : adlist[v]) {
			if (c[n.v] == 0) {
				depth[n.v] = depth[v] + n.weight;
				dfs(n.v, c, depth);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		adlist = (ArrayList<Node1>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Node1>();
		for (int i = 1; i <= N; i++) {
			int root = s.nextInt();
			int a, b;
			while ((a = s.nextInt()) != -1) {
				b = s.nextInt();
				adlist[root].add(new Node1(a, b));
			}
		}
		int[] c = new int[N + 1];
		int[] depth = new int[N + 1];
		dfs(1, c, depth);
		int max = 0; // ���� �� ��� �� ����
		int max_v = 0;
		for (int i = 2; i <= N; i++) {
			if (max < depth[i]) {
				max = depth[i];
				max_v = i;
			}
		}
		int[] depth1 = new int[N + 1];
		int[] c1 = new int[N + 1];
		dfs(max_v, c1, depth1);
		max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < depth1[i])
				max = depth1[i];
		}
		System.out.println(max);
	}

}
