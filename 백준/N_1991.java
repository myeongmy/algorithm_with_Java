//백준 1991번
/*문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.*/

package 백준;

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
