//���� 1967�� (1167�� ���� ����)
/*����
Ʈ��(tree)�� ����Ŭ�� ���� ������ �׷����̴�. Ʈ�������� � �� ��带 �����ص� �� ���̿� ��ΰ� �׻� �ϳ��� �����ϰ� �ȴ�. Ʈ������ � �� ��带 �����ؼ� �������� �� ��� ��, ���� ��� �þ�� ��찡 ���� ���̴�. �̷� �� Ʈ���� ��� ������ �� �� ��带 ������ �� ������ �ϴ� �� �ȿ� ���� �ȴ�.



�̷� �� ��� ������ ����� ���̸� Ʈ���� �����̶�� �Ѵ�. ��Ȯ�� �������ڸ� Ʈ���� �����ϴ� ��� ��ε� �߿��� ���� �� ���� ���̸� ���Ѵ�.

�Է����� ��Ʈ�� �ִ� Ʈ���� ����ġ�� �ִ� ������� �� ��, Ʈ���� ������ ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. �Ʒ��� ���� Ʈ���� �־����ٸ� Ʈ���� ������ 45�� �ȴ�.



�Է�
������ ù ��° ���� ����� ���� n(1 �� n �� 10,000)�̴�. ��° �ٺ��� n��° �ٱ��� �� ������ ���� ������ ���´�. ������ ���� ������ �� ���� ������ �̷���� �ִ�. ù ��° ������ ������ �����ϴ� �� ��� �� �θ� ����� ��ȣ�� ��Ÿ����, �� ��° ������ �ڽ� ��带, �� ��° ������ ������ ����ġ�� ��Ÿ����. ������ ���� ������ �θ� ����� ��ȣ�� ���� ���� ���� �Էµǰ�, �θ� ����� ��ȣ�� ������ �ڽ� ����� ��ȣ�� ���� ���� ���� �Էµȴ�. ��Ʈ ����� ��ȣ�� �׻� 1�̶�� �����ϸ�, ������ ����ġ�� 100���� ũ�� ���� ���� �����̴�.

���
ù° �ٿ� Ʈ���� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1967 {
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
		int n = s.nextInt();
		adlist = (ArrayList<Node1>[]) new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			adlist[i] = new ArrayList<Node1>();

		for (int i = 1; i < n; i++) {
			int p = s.nextInt();
			int c = s.nextInt();
			int w = s.nextInt();

			adlist[p].add(new Node1(c, w));
			adlist[c].add(new Node1(p, w));
		}

		// 1. ������ �������� ��� �������� �Ÿ� ���ϱ�
		int[] c = new int[n + 1];
		int[] depth = new int[n + 1];
		dfs(1, c, depth);

		int max = 0;
		int max_v = 0;
		for (int i = 2; i <= n; i++) {
			if (max < depth[i]) {
				max = depth[i];
				max_v = i;
			}
		}

		// 2. �ִ� �������κ��� ��� �������� �Ÿ� ���ϱ�
		int[] c1 = new int[n + 1];
		int[] depth1 = new int[n + 1];
		dfs(max_v, c1, depth1);

		max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < depth1[i])
				max = depth1[i];
		}
		System.out.println(max);
	}

}
