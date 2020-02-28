//���� 1991��
/*����
���� Ʈ���� �Է¹޾� ���� ��ȸ(preorder traversal), ���� ��ȸ(inorder traversal), ���� ��ȸ(postorder traversal)�� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.



���� ��� ���� ���� ���� Ʈ���� �ԷµǸ�,

���� ��ȸ�� ��� : ABDCEFG // (��Ʈ) (���� �ڽ�) (������ �ڽ�)
���� ��ȸ�� ��� : DBAECFG // (���� �ڽ�) (��Ʈ) (������ �ڽ�)
���� ��ȸ�� ��� : DBEGFCA // (���� �ڽ�) (������ �ڽ�) (��Ʈ)
�� �ȴ�.

�Է�
ù° �ٿ��� ���� Ʈ���� ����� ���� N(1��N��26)�� �־�����. ��° �ٺ��� N���� �ٿ� ���� �� ���� ���� ���� �ڽ� ���, ������ �ڽ� ��尡 �־�����. ����� �̸��� A���� ���ʴ�� ������ �빮�ڷ� �Ű�����, �׻� A�� ��Ʈ ��尡 �ȴ�. �ڽ� ��尡 ���� ��쿡�� .���� ǥ���ȴ�.

���
ù° �ٿ� ���� ��ȸ, ��° �ٿ� ���� ��ȸ, ��° �ٿ� ���� ��ȸ�� ����� ����Ѵ�. �� �ٿ� N���� ���ĺ��� ���� ���� ����ϸ� �ȴ�.*/

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

public class N_1991 {
	static void preorder(int index, Node[] n) {
		if (index == -1)
			return;
		System.out.print((char) (index + 65));
		preorder(n[index].left, n);
		preorder(n[index].right, n);
	}

	static void inorder(int index, Node[] n) {
		if (index == -1)
			return;
		inorder(n[index].left, n);
		System.out.print((char) (index + 65));
		inorder(n[index].right, n);

	}

	static void postorder(int index, Node[] n) {
		if (index == -1)
			return;
		postorder(n[index].left, n);
		postorder(n[index].right, n);
		System.out.print((char) (index + 65));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Node[] n = new Node[N];
		for (int i = 0; i < N; i++) {
			char root = s.next().charAt(0);
			char left = s.next().charAt(0);
			int l;
			if (left == '.') {
				l = -1;
			} else {
				l = left - 65;
			}
			char right = s.next().charAt(0);
			int r;
			if (right == '.') {
				r = -1;
			} else {
				r = right - 65;
			}
			n[root - 65] = new Node(l, r);
		}
		// preorder
		preorder(0, n);
		System.out.println();

		// inorder
		inorder(0, n);
		System.out.println();

		// postorder
		postorder(0, n);
		System.out.println();

	}

}
