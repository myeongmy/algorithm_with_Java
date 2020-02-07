//���� 15684��(��ٸ� ����)
//����Ž���� �ùķ��̼� ����
/*����
��ٸ� ������ N���� ���μ��� M���� ���μ����� �̷���� �ִ�. ������ ���μ� ���̿��� ���μ��� ���� �� �ִµ�, ������ ���μ����� ���μ��� ���� �� �ִ� ��ġ�� ������ H�̰�, ��� ���μ��� ���� ��ġ�� ���´�. �Ʒ� �׸��� N = 5, H = 6 �� ����� �׸��̰�, ���μ��� ����.



�ʷϼ��� ���μ��� ��Ÿ����, �ʷϼ��� ������ �����ϴ� ���� ���μ��� ���� �� �ִ� ���̴�. ���μ��� ������ �� ���μ��� �����ؾ� �Ѵ�. ��, �� ���μ��� �����ϰų� ���� ���ϸ� �� �ȴ�. ��, ���μ��� ���� ���� �־�� �Ѵ�.



���� �׸����� ���μ��� �� 5�� �ִ�. ���μ��� ���� �׸��� ���� ������ �� ���μ��� �����ؾ� �ϰ�, ���μ��� ���� �� �ִ� ��ġ�� �����ؾ� �Ѵ�.

��ٸ� ������ ������ ���μ����� ������ �����ϰ�, ���μ��� ���� ���������� �Ʒ� �������� �������� �Ѵ�. �̶�, ���μ��� ������ ���μ��� �̿��� �� ���μ����� �̵��� ����, �̵��� ���μ����� �Ʒ� �������� �̵��ؾ� �Ѵ�.

���� �׸����� 1���� 3������, 2���� 2������, 3���� 5������, 4���� 1������, 5���� 4������ �����ϰ� �ȴ�. �Ʒ� �� �׸��� 1���� 2���� ��� �̵��ߴ��� ��Ÿ���� �׸��̴�.

	
1�� ���μ�	2�� ���μ�
��ٸ��� ���μ��� �߰��ؼ�, ��ٸ� ������ ����� �����Ϸ��� �Ѵ�. �̶�, i�� ���μ��� ����� i���� ���;� �Ѵ�. �׷��� �ϱ� ���ؼ� �߰��ؾ� �ϴ� ���μ� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���μ��� ���� N, ���μ��� ���� M, ���μ����� ���μ��� ���� �� �ִ� ��ġ�� ���� H�� �־�����. (2 �� N �� 10, 1 �� H �� 30, 0 �� M �� (N-1)��H)

��° �ٺ��� M���� �ٿ��� ���μ��� ������ �� �ٿ� �ϳ��� �־�����.

���μ��� ������ �� ���� a�� b�� ��Ÿ����. (1 �� a �� H, 1 �� b �� N-1) b�� ���μ��� b+1�� ���μ��� a�� ���� ��ġ���� �����ߴٴ� �ǹ��̴�.

���� ���� �ִ� ������ ��ȣ�� 1���̰�, �Ʒ��� ������ ������ 1�� �����Ѵ�. ���μ��� ���� ���ʿ� �ִ� ���� ��ȣ�� 1���̰�, ���������� �� ������ 1�� �����Ѵ�.

�Է����� �־����� ���μ��� ���� �����ϴ� ���� ����.

���
i�� ���μ��� ����� i���� �������� ��ٸ� ������ �����Ϸ���, �߰��ؾ� �ϴ� ���μ� ������ �ּڰ��� ����Ѵ�. ����, ������ 3���� ū ���̸� -1�� ����Ѵ�. ��, �Ұ����� ��쿡�� -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_15684 {
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int[][] A;
	static int find = 0;

	static int calc(int[][] A) { // �ùٸ� ��ٸ����� �˻��ϴ� �ڵ�
		for (int i = 1; i <= A[0].length - 1; i++) {
			int h = 0; // ���� ����
			int line = i; // ���� ���� ��ȣ

			while (h < A.length - 1) {
				h += 1;
				if (A[h][line - 1] == 1) {
					line -= 1;
				} else if (A[h][line] == 1) {
					line += 1;
				}
			}
			if (i != line)
				return -1;
		}
		return 1;
	}

	static void go(int index, int selected, ArrayList<Point> list, int count, int[] c) {
		if (selected == count) {

			if (result.size() >= 2) {
				if (list.get(result.get(0)).i == list.get(result.get(1)).i
						&& Math.abs(list.get(result.get(0)).i - list.get(result.get(1)).j) == 1)
					return;
			}

			int[][] test = new int[A.length][A[0].length];
			for (int i = 0; i < test.length; i++)
				test[i] = A[i].clone();
			for (int i = 0; i < result.size(); i++) {
				test[list.get(result.get(i)).i][list.get(result.get(i)).j] = 1;
			}
			if (calc(test) == 1)
				find = 1;
			return;
		}
		if(index >= list.size()) return;
		result.add(index);
		go(index+1, selected+1, list, count, c);
		result.remove(result.size()-1);
		
		go(index+1, selected, list, count, c);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int H = s.nextInt();
		A = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			A[s.nextInt()][s.nextInt()] = 1;
		}
		ArrayList<Point> list = new ArrayList<Point>(); // �߰� ������ ��ٸ� ��ġ ����
		// ��ٸ� 0�� �߰����� ��
		if (calc(A) == 1) {
			System.out.println(0);
			System.exit(0);
		}

		// �߰� ������ ��ٸ� Ž��
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N - 1; j++) {
				if (A[i][j] != 1 && A[i][j - 1] != 1 && A[i][j + 1] != 1)
					list.add(new Point(i, j));
			}
		}
		// ��ٸ� 1�� �߰��ϱ�
		int[] c = new int[list.size()];
		go(0, 0, list, 1, c);
		if (find == 1) {
			System.out.println(1);
			System.exit(0);
		}

		// ��ٸ� 2�� �߰��ϱ�
		find = 0;
		int[] c1 = new int[list.size()];
		go(0, 0, list, 2, c1);
		if (find == 1) {
			System.out.println(2);
			System.exit(0);
		}
		// ��ٸ� 3�� �߰��ϱ�
		find = 0;
		int[] c2 = new int[list.size()];
		go(0, 0, list, 3, c1);
		if (find == 1) {
			System.out.println(3);
			System.exit(0);
		}
		System.out.println(-1);

	}

}
