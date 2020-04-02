//[SW Test ���ù���] ���μ��� �����ϱ�
//���Ʈ ���� ����
/*�Ｚ���� ������ �ֽ� ����� ���μ��� �߽ó뽺�� ���� N�� x ���� N���� cell�� �����Ǿ� �ִ�.



1���� cell���� 1���� Core Ȥ�� 1���� ������ �� �� �ִ�.


�߽ó뽺�� ���� �ڸ����� ������ �帣�� �ִ�.

Core�� ������ �����ϴ� ������ �������θ� ��ġ�� �����ϸ�,


������ ����� �����ؼ��� �� �ȴ�.

�ʱ� ���·δ� �Ʒ��� ���� ������ �����ϱ� �� ������ �߽ó뽺 ������ �־�����.


(�߽ó뽺�� �����ڸ��� ��ġ�� Core�� �̹� ������ ����� ������ �����Ѵ�.)





�� �ִ��� ���� Core�� ������ �����Ͽ��� ���, ���� ������ ���� ���ϰ��� �Ѵ�.

   ��, ���� ����� ���� ���, ���� ������ ���� �ּҰ� �Ǵ� ���� ���϶�.

�� ������ ������ 12�� �ȴ�.



[���� ����]

1. 7 ��  N �� 12

2. Core�� ������ �ּ� 1�� �̻� 12�� �����̴�.

3. �ִ��� ���� Core�� ������ �����ص�, ������ ������� �ʴ� Core�� ������ �� �ִ�.



[�Է�]

�Է��� ���� ù �ٿ��� �� �׽�Ʈ ���̽��� ���� T�� �־����� �� ���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù �ٿ��� N���� �־�����, ���� N�ٿ� ���ļ� �߽ó뽺�� �ʱ� ���°� N x N �迭�� �־�����.

0�� �� cell�� �ǹ��ϸ�, 1�� core�� �ǹ��ϰ�, �� ���� ���ڴ� �־����� �ʴ´�.



[���]

�� �׽�Ʈ ���̽����� '#X'�� ���, �� ĭ ���, ������ ����Ѵ�.

(X�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;
import java.io.*;

public class SWEA_1767 {
	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[][] A;
	static int[][] c; // �湮 ���� ����
	static ArrayList<Point> cell = new ArrayList<Point>(); // ������ �����ؾ��� cell ����
	static int connectedCell = 0;
	static int length = 0;
	static int max = Integer.MIN_VALUE;
	static int min_length = Integer.MAX_VALUE;

	static boolean check_up(int index, int j) {
		for (int i = 0; i <= index; i++) {
			if (A[i][j] != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean check_down(int index, int j) {
		for (int i = index; i < A.length; i++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean check_left(int index, int i) {
		for (int j = 0; j <= index; j++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean check_right(int index, int i) {
		for (int j = index; j < A.length; j++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_up(int index, int j) {
		for (int i = 0; i <= index; i++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_down(int index, int j) {
		for (int i = index; i < A.length; i++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_left(int index, int i) {
		for (int j = 0; j <= index; j++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_right(int index, int i) {
		for (int j = index; j < A.length; j++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static void go(int index) {
		if (index == cell.size()) {
			if (max < connectedCell) { // ����� cell ������ ���� Ŭ ���� ���̸� �����ϰ�
				max = connectedCell;
				min_length = length;
			} else if (max == connectedCell) { // ���� ���� ���̳��� ��
				if (min_length > length)
					min_length = length;
			}
			return;
		}
		// ��
		if (check_up(cell.get(index).i - 1, cell.get(index).j)) {
			if (visited_up(cell.get(index).i - 1, cell.get(index).j)) {
				for (int i = 0; i < cell.get(index).i; i++) {
					c[i][cell.get(index).j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int i = 0; i < cell.get(index).i; i++) {
					c[i][cell.get(index).j] = 0;
					length--;
				}
			}
		}
		// ��
		if (check_down(cell.get(index).i + 1, cell.get(index).j)) {
			if (visited_down(cell.get(index).i + 1, cell.get(index).j)) {
				for (int i = cell.get(index).i + 1; i < A.length; i++) {
					c[i][cell.get(index).j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int i = cell.get(index).i + 1; i < A.length; i++) {
					c[i][cell.get(index).j] = 0;
					length--;
				}
			}
		}
		// ��
		if (check_left(cell.get(index).j - 1, cell.get(index).i)) {
			if (visited_left(cell.get(index).j - 1, cell.get(index).i)) {
				for (int j = 0; j < cell.get(index).j; j++) {
					c[cell.get(index).i][j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int j = 0; j < cell.get(index).j; j++) {
					c[cell.get(index).i][j] = 0;
					length--;
				}
			}
		}
		// ��
		if (check_right(cell.get(index).j + 1, cell.get(index).i)) {
			if (visited_right(cell.get(index).j + 1, cell.get(index).i)) {
				for (int j = cell.get(index).j + 1; j < A.length; j++) {
					c[cell.get(index).i][j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int j = cell.get(index).j + 1; j < A.length; j++) {
					c[cell.get(index).i][j] = 0;
					length--;
				}
			}
		}
		// �� ���� �Ѿ�� ��� (�� �ټ� ���� ����� ��)
		go(index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				A = new int[N][N];
				c = new int[N][N];
				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr[k]);
						if (A[j][k] == 1 && j != 0 && j != N - 1 && k != 0 && k != N - 1)
							cell.add(new Point(j, k));
					}
				}

				go(0);
				System.out.println("#" + (i + 1) + " " + min_length);
				max = Integer.MIN_VALUE;
				min_length = Integer.MAX_VALUE;
				cell.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
