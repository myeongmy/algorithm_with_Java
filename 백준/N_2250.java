//���� 2250��
/*����
����Ʈ���� ������ ��Ģ�� ���� ��� ���� ��ȣ�� �پ��ִ� ���� ����� Ʋ �ӿ� �׸����� �Ѵ�. �̶� ������ ��Ģ�� ���� �׸����� �Ѵ�.

����Ʈ������ ���� ����(level)�� �ִ� ���� ���� �࿡ ��ġ�Ѵ�.
�� ������ �� ��常 �����Ѵ�.
������ ����� ���� ��Ʈ��(left subtree)�� �ִ� ������ �ش� ��庸�� ������ ���� ��ġ�ϰ�, ������ ��Ʈ��(right subtree)�� �ִ� ������ �ش� ��庸�� �������� ���� ��ġ�Ѵ�.
��尡 ��ġ�� ���� ���� ���� ������ �� ���̿� �ƹ� ��嵵 ���� ����ִ� ���� ����.
�̿� ���� ��Ģ�� ���� ����Ʈ���� �׸� �� �� ������ �ʺ�� �� ������ �Ҵ�� ��� �� ���� �����ʿ� ��ġ�� ����� �� ��ȣ���� ���� ���ʿ� ��ġ�� ����� �� ��ȣ�� �� �� ���ϱ� 1�� �����Ѵ�. Ʈ���� ������ ���� ���ʿ� �ִ� ��Ʈ ��尡 1�̰� �Ʒ��� 1�� �����Ѵ�.

�Ʒ� �׸��� � ����Ʈ���� ���� ��Ģ�� ���� �׷� �� ���̴�. ù ��° ������ �ʺ�� 1, �� ��° ������ �ʺ�� 13, 3��°, 4��° ������ �ʺ�� ���� 18�̰�, 5��° ������ �ʺ�� 13�̸�, �׸��� 6��° ������ �ʺ�� 12�̴�.



�츮�� �־��� ����Ʈ���� ���� ��Ģ�� ���� �׸� ���� �ʺ� ���� ���� ������ �� ������ �ʺ� ����Ϸ��� �Ѵ�. ���� �׸��� ������ �ʺ� ���� ���� ������ 3��°�� 4��°�� �� �ʺ�� 18�̴�. �ʺ� ���� ���� ������ �� �� �̻� ���� ���� ��ȣ�� ���� ������ ������ �Ѵ�. �׷��Ƿ� �� ���� ���� ���� ������ 3�̰�, �ʺ�� 18�̴�.

������ ����Ʈ���� �Է����� �־��� �� �ʺ� ���� ���� ������ �� ������ �ʺ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�

�Է�
ù° �ٿ� ����� ������ ��Ÿ���� ���� N(1 �� N �� 10,000)�� �־�����. ���� N���� �ٿ��� �� �ٸ��� ��� ��ȣ�� �ش� ����� ���� �ڽ� ���� ������ �ڽ� ����� ��ȣ�� ������� �־�����. ������ ��ȣ�� 1���� N�����̸�, �ڽ��� ���� ��쿡�� �ڽ� ����� ��ȣ�� -1�� �־�����.

���
ù° �ٿ� �ʺ� ���� ���� ������ �� ������ �ʺ� ������� ����Ѵ�. �ʺ� ���� ���� ������ �� �� �̻� ���� ������ ��ȣ�� ���� ������ ����Ѵ�.*/

package ����;

import java.util.*;

class Node {
	int left;
	int right;

	Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

class Info {
	int v;
	int level;

	Info(int v, int level) {
		this.v = v;
		this.level = level;
	}
}

public class N_2250 {
	static int max_depth = 0;
	static int start = 1;

	static void inorder(int v, Node[] n, int depth, Info[] info) {
		if (v == -1)
			return;
		if (max_depth < depth)
			max_depth = depth;
		inorder(n[v].left, n, depth + 1, info);
		info[start] = new Info(v, depth);
		start++;
		inorder(n[v].right, n, depth + 1, info);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		Node[] n = new Node[N + 1];
		int[] parent = new int[N + 1]; // ��Ʈ ��� ã�� ���� �迭
		for (int i = 1; i <= N; i++)
			parent[i] = -1;
		for (int i = 1; i <= N; i++) {
			int root = s.nextInt();
			int left = s.nextInt();
			int right = s.nextInt();

			n[root] = new Node(left, right);
			if (left != -1)
				parent[left] = root;
			if (right != -1)
				parent[right] = root;
		}
		int rootNode = 0;
		for (int i = 1; i <= N; i++) {
			if (parent[i] == -1)
				rootNode = i;
		}
		Info[] info = new Info[N + 1]; // �ε���: ���� ����, v: ���� ��ȣ, level: fpqpf
		inorder(rootNode, n, 1, info);
		int fi_level = 0;
		int fi_width = 0;
		for (int i = 1; i <= max_depth; i++) {
			int min = 10001;
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (info[j].level == i) {
					if (min > j)
						min = j;
					if (max < j)
						max = j;
				}
			}
			int width = max - min + 1;
			if (fi_width < width) {
				fi_width = width;
				fi_level = i;
			}
		}
		System.out.println(fi_level + " " + fi_width);
	}

}
