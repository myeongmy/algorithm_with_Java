//2020-03-21 Gaaaaaaarden �Ｚ ���� ���� ���ǰ��
//bfs+���Ʈ ���� ����

/*����
��� ����� �ܿ��� ������ BOJ �������� ���� ã�ƿԴ�. BOJ ���������� ���� ���� ������ ������ �ǿ���� �Ѵ�. ������ ���� ȣ���� �̷���� �ְ� 2���� ������ ����̴�.

�ΰǺ� ������ ���� BOJ ���������� ���� ����� ������ �ɴ� ��� �ʷϻ� ���װ� ������ ������ ���� �����ϰ� �ѷ��� ���� �ǿ� ���̴�. �� �� ������ �Ѹ� �� �ִ� ���� �̸� �������ִ�.

������ �� �ʸ��� ������ ������ ������ ���� ���� ������ ������ ��������.

�Ʒ��� �ʷϻ� ���� 2���� �ѷ��� ���� �����̴�. �Ͼ�� ĭ�� ������ �Ѹ� �� ���� ����, Ȳ��� ĭ�� ������ �Ѹ� �� �ִ� ����, �ϴû� ĭ�� ȣ���� �ǹ��Ѵ�.



�ʷϻ� ���װ� ������ ������ ������ �ð��� ������ �������� �� ������ �������� ���� �Ǿ��. ���� �Ǿ �������� ������ ������� ������ �� �̻� ������ ������ ������ ��Ʈ���� �ʴ´�.

�Ʒ��� �ʷϻ� ���� 2���� ������ ���� 2���� �ѷ��� ���� �����̴�.



������ ���� ������ ����� �� ���� �ǹǷ� �־��� ��� ������ ������� ����ؾ� �Ѵ�. ���� ��� �ʷϻ� ���� 2���� ������ ���� 2���� �־����µ� �ʷϻ� ���� 1���� ���� �Ѹ��� �ʰ�, �ʷϻ� ���� 1���� ������ ���� 2������ ����ϴ� ���� �Ұ����ϴ�.

���� ��� ������ ���� �ٸ� ���� �ѷ����� �Ѵ�.

������ �� ������ ������ �־������� �� �ǿ� �� �ִ� ���� �ִ� ������ ���غ���.

�Է�
ù° �ٿ� ������ ���� ������ ���� ������ ��Ÿ���� N(2 �� N �� 50)�� M(2 �� M �� 50), �׸��� �ʷϻ� ������ ���� G(1 �� G �� 5)�� ������ ������ ���� R(1 �� R �� 5)�� �� ĭ�� ��ĭ�� ���̿� �ΰ� �־�����.

�� ���� N���� �ٿ��� �� �ٸ��� ������ �� ���� ��Ÿ���� M���� ������ �� ���� �� ĭ�� ���̿� �ΰ� �־�����. �� ĭ�� ���� ���� 0, 1, 2�̴�. 0�� ȣ��, 1�� ������ �Ѹ� �� ���� ��, 2�� ������ �Ѹ� �� �ִ� ���� �ǹ��Ѵ�.

������ �Ѹ� �� �ִ� ���� ���� R+G�� �̻��̰� 10�� �����̴�.

���
ù° �ٿ� �ǿ� �� �ִ� ���� �ִ� ������ ����Ѵ�.*/

package �ڵ��׽�Ʈ;

import java.util.*;
import java.io.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	 @Override            // HashSet�� �ߺ��� �����ϱ� ���� ��� -> �ٵ� Wrapper class�� �ƴ� Custom class ���� �ߺ� �����Ϸ��� hashCode()�� equals(Object o)�޼ҵ带 �������̵� ���־����!
	 public int hashCode()
	 {
	  return Integer.toString(i).hashCode()+Integer.toString(j).hashCode();
	 }
	 
	 @Override
	 public boolean equals(Object o)
	 {
		 Point p = (Point)o;
	  return (this.i == p.i && this.j == p.j);
	 }
}

class Fluid {
	int color;
	int time;

	Fluid(int color, int time) {
		this.color = color;
		this.time = time;
	}
}

public class Gaaaaaarden {
	static ArrayList<Point> list = new ArrayList<Point>();
	static ArrayList<Integer> green = new ArrayList<Integer>(); // �ʷϻ� ���� �Ѹ��� �� ��ȣ
	static ArrayList<Integer> red = new ArrayList<Integer>();
	static ArrayList<Integer> nothing = new ArrayList<Integer>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	static void go(int index, int G, int R, int[][] A) {
		if (index == list.size()) {
			if (green.size() != G || red.size() != R)
				return;

			Fluid[][] c = new Fluid[A.length][A[0].length];
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					c[i][j] = new Fluid(-1, -1); // 0�� �ʷ�, 1�� ����
				}
			}
			// bfs
			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < green.size(); i++) {
				c[list.get(green.get(i)).i][list.get(green.get(i)).j].color = 0;
				c[list.get(green.get(i)).i][list.get(green.get(i)).j].time = 0;
				q.offer(new Point(list.get(green.get(i)).i, list.get(green.get(i)).j));
			}
			for (int i = 0; i < red.size(); i++) {
				c[list.get(red.get(i)).i][list.get(red.get(i)).j].color = 1;
				c[list.get(red.get(i)).i][list.get(red.get(i)).j].time = 0;
				q.offer(new Point(list.get(red.get(i)).i, list.get(red.get(i)).j));
			}

			HashSet<Point> flower = new HashSet<Point>();    //�ߺ� ���� ����

			Label: while (!q.isEmpty()) {
				Point p = q.poll();
				Iterator<Point> it = flower.iterator();
				while(it.hasNext()) {
					Point p1 = it.next();
					if(p1.i == p.i && p1.j == p.j)
						continue Label;
				}
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (A[p.i + dx[i]][p.j + dy[i]] != 0) { // ȣ���� �ƴ� �� �߿���
							if (c[p.i + dx[i]][p.j + dy[i]].time == -1) { // �湮 ���� ��
								c[p.i + dx[i]][p.j + dy[i]].time = c[p.i][p.j].time + 1;
								c[p.i + dx[i]][p.j + dy[i]].color = c[p.i][p.j].color;
								q.offer(new Point(p.i + dx[i], p.j + dy[i]));

							} else if (c[p.i + dx[i]][p.j + dy[i]].color != -1
									&& c[p.i + dx[i]][p.j + dy[i]].color != c[p.i][p.j].color
									&& c[p.i + dx[i]][p.j + dy[i]].time == c[p.i][p.j].time + 1) { // ���� ����� ���
								
									flower.add(new Point(p.i + dx[i], p.j + dy[i]));
							}
						}
					}
				}
			}

			if (max < flower.size())
				max = flower.size();
			return;
		}
		green.add(index);
		go(index + 1, G, R, A);
		green.remove(green.size() - 1);

		red.add(index);
		go(index + 1, G, R, A);
		red.remove(red.size() - 1);

		nothing.add(index);
		go(index + 1, G, R, A);
		nothing.remove(nothing.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int G = Integer.parseInt(arr[2]);
			int R = Integer.parseInt(arr[3]);

			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				String[] arr1 = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					A[i][j] = Integer.parseInt(arr1[j]); // 0�� ȣ��, 1�� �Ѹ� �� ���� ��, 2�� �Ѹ� �� �ִ� ��
					if (A[i][j] == 2)
						list.add(new Point(i, j));
				}
			}

			go(0, G, R, A);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
